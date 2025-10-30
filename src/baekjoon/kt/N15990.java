package baekjoon.kt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N15990 {

    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[] qs = new int[T];
        int maxN = 0;
        for(int i=0; i<T; i++){
            qs[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(qs[i], maxN);
        }

        long[][] dp = new long[Math.max(4, maxN + 1)][4];
        // dp[합][끝나는 숫자]
        // dp[3][1] -> 마지막 숫자가 1인 경우 3이 되는 경우는 (2+1) 하나의 경우의 수 뿐
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1; // 2+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3

        for(int n=4; n<=maxN; n++){
            dp[n][1] = (dp[n-1][2] + dp[n-1][3]) % MOD;
            dp[n][2] = (dp[n-2][1] + dp[n-2][3]) % MOD;
            dp[n][3] = (dp[n-3][1] + dp[n-3][2]) % MOD;
        }

        for(int n : qs){
            long ans = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
    }
}
