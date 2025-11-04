package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        예를 들어, 카드팩이 총 4가지 종류가 있고,
        P1 = 1, P2 = 5, P3 = 6, P4 = 7인 경우에
        민규가 카드 4개를 갖기 위해 지불해야 하는 금액의 최솟값은 4원이다. 1개 들어있는 카드팩을 4번 사면 된다.

        P1 = 5, P2 = 2, P3 = 8, P4 = 10인 경우에는
        카드가 2개 들어있는 카드팩을 2번 사면 4원이고, 이 경우가 민규가 지불해야 하는 금액의 최솟값이다

        ex) 5개의 카드를 사야하는 경우
        1. p[5]의 카드를 사는 경우
        2. p[4] + 1개를 더 사는 경우
        3. p[3] + 2개를 더 사는 경우
        4. p[2] + 3개를 더 사는 경우
        5. p[1] + 4개를 더 사는 경우

         */

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[N+1];
        for(int i=1; i<=N; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j] + p[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
