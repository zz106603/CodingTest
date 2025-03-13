package baekjoon.dp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N11727 {
    /*
        마지막 경우의 수를 생각해야 함(이전 사각형 크기)
        세로로 1개 -> n-1개의 경우의 수
        가로로 2개 -> n-2개의 경우의 수
        2x2짜리 1개 -> n-2개의 경우의 수
        dp[n] = dp[n-1] + (2 * dp[n-2])
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        if(n == 1){
            System.out.println(1);
            return;
        }
        if(n == 2){
            System.out.println(3);
            return;
        }

        dp[1] = 1;
        dp[2] = 3;
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + (2 * dp[i-2]))%10007;
        }

        System.out.println(dp[n]);
    }
}
