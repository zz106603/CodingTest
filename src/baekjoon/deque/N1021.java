package baekjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        10 3
        2 9 5
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=N; i++){
            deque.offerLast(i);
        }

        int res = 0;
        int idx = 0;
        while(idx < M && !deque.isEmpty()){
            if(arr[idx] == deque.peekFirst()){
                idx++;
                deque.pollFirst();
            }else{
                int target = deque.indexOf(arr[idx]);
                if(deque.size()/2 < target){
                    deque.offerFirst(deque.pollLast());
                }else{
                    deque.offerLast(deque.pollFirst());
                }
                res++;
            }
        }

        System.out.println(res);

    }
}
