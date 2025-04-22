package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /*
            20 2
            HHHHHPPPPPHPHPHPHHHP
            : 7

            이 문제는 Deque로 풀 수 있음
            현재 방식은 사람 기준으로 맨 앞의 버거를 매칭하는 코드로 O(N*K) 시간복잡도를 가짐

            Deque 방식은 맨 앞에 햄버거, 사람 각 위치 index를 저장
            이후에 K값의 차이를 통해 그 범위에 포함하면 deque에서 제거하는 방식으로 사용
         */

        String[] arr = new String[N];
//        boolean[] visit = new boolean[N];
        String[] str = br.readLine().split("");

        for(int i=0; i<N; i++){
            arr[i] = str[i];
//            visit[i] = false;
        }

        int res = 0;

        Deque<Integer> bugger = new ArrayDeque<>();
        Deque<Integer> people = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            if(arr[i].equals("P")){
                people.offerLast(i);
            }else{
                bugger.offerLast(i);
            }
        }

        while(!bugger.isEmpty() && !people.isEmpty()){
            int bIdx = bugger.peekFirst();
            int pIdx = people.peekFirst();

            if(Math.abs(bIdx - pIdx) <= K){
                bugger.pollFirst();
                people.pollFirst();
                res++;
            }else if(bIdx < pIdx){
                bugger.pollFirst();
            }else{
                people.pollFirst();
            }
        }

        // O(N*K)
//        for(int i=0; i<N; i++){
//            if(arr[i].equals("P")){
//                for(int j=-K; j<=K; j++){
//                    if(j == 0) continue;
//
//                    int checkIdx = i+j;
//                    if(checkIdx >= 0 && checkIdx < N && arr[checkIdx].equals("H") && !visit[checkIdx]){
//                        visit[checkIdx] = true;
//                        res++;
//                        break;
//                    }
//                }
//            }
//
//        }
        System.out.println(res);
    }
}
