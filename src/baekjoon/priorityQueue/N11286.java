package baekjoon.priorityQueue;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        /*
            절댓값이 같을 경우, 실제로 작은 값이 앞에 오도록
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b)){
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });

        for(int i=0; i<N; i++){
            if(arr[i] == 0){
                if(!pq.isEmpty()){
                    bw.write(pq.poll()+"\n");
                }else{
                    bw.write(0+"\n");
                }
            }else{
                pq.offer(arr[i]);
            }
        }

        bw.flush();
        bw.close();
    }
}
