package baekjoon.kt;

import java.io.*;
import java.util.*;

public class N19598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        /*
        0 40
        5 10
        15 30

        10 40

        15
         */
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int ans = 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(arr[0][1]);

        for(int i=1; i<N; i++){
            if(!pq.isEmpty()){
                if(pq.peek() <= arr[i][0]){
                    pq.poll();
                }else{
                    ans++;
                }
                pq.add(arr[i][1]);
            }
        }

        System.out.println(ans);

    }
}
