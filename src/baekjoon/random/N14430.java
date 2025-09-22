package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N14430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
        (1, 1) -> (N, M)
        오른쪽, 아래로만 이동 가능
        탐색 자원의 최대 숫자

        1 가능, 0 불가능

        현재 위치가 0이 아니고, 오른쪽이나 아래에 0이 아니면 값을 더한다(현재위치값에 + 1)
         */

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*
        0 1 0 0
        0 0 1 0
        1 1 0 0
        1 0 1 0
        1 1 0 0

        최대값을 구하면 되므로, dp로 가능
        dp를 M으로 두고 4개를 기준으로 아래로 내려오면서 값을 더함
        j == 0일 경우엔, 위에서 밖에 못 내려오므로 dp[j] = dp[j] + val
        j != 0일 경우엔, 왼쪽이나 위에서 내려오므로 Math.max(dp[j], dp[j-1]) + val
         */
//        int[] dp = new int[M];
//        for(int i=0; i<N; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j=0; j<M; j++){
//                int val = Integer.parseInt(st.nextToken());
//                if(j == 0) dp[j] = dp[j] + val;
//                else dp[j] = Math.max(dp[j],dp[j-1]) + val;
//            }
//        }

        int[][] dp = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(i == 0){
                    if(j != 0) dp[i][j] = dp[i][j-1] + dp[i][j];
                }else{
                    if(j == 0) dp[i][j] = dp[i-1][j] + dp[i][j];
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + dp[i][j];
                }

            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}
