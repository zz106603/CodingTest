package baekjoon.random;

import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;

public class N2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            3 7 5 2 6 1 4

            3 5 6이 가장 큰 부분 증가 수열

            N <= 200, dp를 사용하여 부분 증가 수열의 max값을 업데이트
            dp[i] = arr[i]보다 작은 값일 때, max(dp[i], dp[j]+1)
         */


        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){ arr[i] = Integer.parseInt(br.readLine()); }

        int[] dp = new int[N];
        int lis = 0;

        for(int i=0; i<N; i++){
            dp[i] = 1;

            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            lis = Math.max(lis, dp[i]);
        }

        System.out.println(N-lis);

    }
}
