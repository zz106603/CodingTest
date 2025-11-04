package baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

public class N9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int c=0; c<T; c++){
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[11];

            dp[1] = 1;
            dp[2] = 2; // 1+1, 2
            dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

            // dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

            for(int i=4; i<=N; i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            bw.write(dp[N] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
