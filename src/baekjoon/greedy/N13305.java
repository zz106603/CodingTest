package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] dist = new long[N-1];
        for(int i=0; i<N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long[] amount = new long[N];
        for(int i=0; i<N; i++){
            amount[i] = Integer.parseInt(st.nextToken());
        }

        long minValue = amount[0];
        long res = 0;
        for(int i=0; i<N-1; i++){
            minValue = Math.min(minValue, amount[i]);

            res += minValue*dist[i];
        }

        System.out.println(res);
    }
}
