package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N15270 {

    static List<Integer>[] friends;
    static int N, M;
    static boolean[] visit;
    static int maxPair = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            friends[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        visit = new boolean[N+1];

        // 현재 학생 인덱스, 현재 짝의 개수
        dfs(1, 0);

        int ans = maxPair * 2 + (maxPair * 2 < N ? 1 : 0);
        System.out.println(ans);

    }

    public static void dfs(int idx, int pairCount){
        // 탐색 끝
        if(idx > N){
            maxPair = Math.max(maxPair, pairCount);
            return;
        }

        // 연결된 쌍이 있으면 다음으로 넘어감
        if(visit[idx]){
            dfs(idx + 1, pairCount);
            return;
        }

        // 혼자 로봇춤을 출 경우의 수
        dfs(idx + 1, pairCount);

        // 친구와 쌍을 지을 경우의 수
        for(int f : friends[idx]){
            if(!visit[f]){
                visit[idx] = visit[f] = true;
                dfs(idx + 1, pairCount + 1);
                visit[idx] = visit[f] = false;
            }
        }
    }
}
