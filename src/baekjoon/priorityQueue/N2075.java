package baekjoon.priorityQueue;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                long num = Long.parseLong(st.nextToken());
                pq.offer(num);
                if(pq.size() > N){
                    pq.poll();
                }
            }
        }

        Long res = pq.peek();

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
