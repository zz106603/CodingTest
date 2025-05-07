package baekjoon.priorityQueue;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class N11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
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
