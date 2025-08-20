package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N13699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        /*
            t(1)=t(0)*t(0)=1
            t(2)=t(0)*t(1)+t(1)*t(0)=2
            t(3)=t(0)*t(2)+t(1)*t(1)+t(2)*t(0)=5

            t(n)=t(0)*t(n-1)+t(1)*t(n-2)+...+t(n-1)*t(0)

            t(n) = ∑(t(i)*t(n-1-i)) (i=0..n-1)
         */

        long[] dp = new long[n+1];
        dp[0] = 1L;

        for(int k=1; k<=n; k++){ // 누적이 필요하기 때문에 여기서 k = n이 되면서 누적
            long sum = 0L;
            for(int i=0; i<k; i++){
                sum += dp[i]*dp[k-1-i];
            }
            dp[k] = sum;
        }

        System.out.println(dp[n]);


    }
}
