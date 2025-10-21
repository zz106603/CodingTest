package baekjoon.random;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int k=0; k<T; k++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(pq.isEmpty()) bw.write(0 + "\n");
                else bw.write(pq.poll() + "\n");
            }else{
                pq.offer(num);
            }
        }

        bw.flush();
        bw.close();
    }
}
