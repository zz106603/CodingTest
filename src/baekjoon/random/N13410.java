package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N13410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i=1; i<=K; i++){
            int val = N*i;

            int reverseNum = Integer.parseInt(new StringBuilder(String.valueOf(val)).reverse().toString());
            ans = Math.max(ans, reverseNum);
        }

        System.out.println(ans);
    }
}
