package baekjoon.random;

import java.io.*;
import java.util.*;

public class N16432 {

    static int K;
    static int[][] arr;
    static boolean flag = false;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            이 문제의 키포인트
            1. 이전 날짜와 다른 종류의 떡을 줘야함 -> 백트래킹으로 가능한 상황을 구현
            2. 백트래킹으로 상황 구현 중 day, prev 값을 기준으로 실패하면 항상 안됨
                - for문을 다 돌았는데 되지 않는 상황이면 visit[day][prev] = true를 통해 항상 불가능하다고 정의
                - if(visit[day][prev]) return; 을 통해 불필요한 dfs로직 방지

            백트래킹이라는 알고리즘을 떠올린 것 자체는 좋았음
            하지만, 전체 중복을 거르는 문제가 아니라 전 날과만 다르면 된다는 문제 의도 파악 실패
            추가로, dfs를 효과적으로 사용하기 위해 실패한 dfs의 재호출을 방지하기 위해 visit를 활용해야 함
         */

        K = Integer.parseInt(br.readLine());

        arr = new int[K][10];
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<count; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[K][10];
        for(int i=0; i<arr[0].length; i++){
            int cur = arr[0][i];
            if(cur == 0) break;
            List<Integer> res = new ArrayList<>();
            res.add(cur);
            dfs(1, cur, res);
        }

        if(sb.length() == 0){
            System.out.println(-1);
        }else{
            System.out.println(sb.toString());
        }

    }

    public static void dfs(int day, int prev, List<Integer> res){
        if(flag) return;
        if(day == K){
            for(int i=0; i<res.size(); i++){
                if(i == res.size()-1) sb.append(res.get(i));
                else sb.append(res.get(i)).append("\n");
            }
            flag = true;
            return;
        }

        // 이전 행이랑 같은 값이면 이미 실패
        if(visit[day][prev]) return;

        for(int i=0; i<arr[day].length; i++){
            int cur = arr[day][i];
            if(cur == 0) break;

            if(cur != prev){
                res.add(cur);
                dfs(day+1, cur, res);
                res.remove(res.size()-1);
            }

        }

        if(!flag) visit[day][prev] = true;
    }
}
