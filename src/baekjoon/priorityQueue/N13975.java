package baekjoon.priorityQueue;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        C1, C2, C3, C4가 네 개의 장을 수록하고 있는 파일이고, 파일 크기가 각각 40, 30, 30, 50

        40+30
        30+50
        70+80
        = 300

        30+30
        60+40
        100+50
        = 310

         */

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++){
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long res = 0;

//            int count = 0;
//            while(count < N){
//
//                while(st.hasMoreTokens()){
//                    pq.offer(Long.parseLong(st.nextToken()));
//                    count++;
//                }
//            }

            for(int j=0; j<N; j++){
               pq.offer(Long.parseLong(st.nextToken()));
            }

            while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll(); // 최소 queue 크기가 3개 이상 보장되어있음
                pq.offer(a + b);
                res += (a+b);
            }

            bw.write(res + "\n");
        }

        bw.flush();
        bw.close();
    }
}
