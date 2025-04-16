package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][][] dp = new int[N][M][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<3; j++){
                dp[0][i][j] = arr[0][i];
            }
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<M; j++){
                // 방향 : 0 -> 왼쪽, 1 -> 중앙, 2 -> 오른쪽
                if(j == 0){
                    dp[i][j][0] = Integer.MAX_VALUE;
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                }else if(j == M-1){
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    dp[i][j][2] = Integer.MAX_VALUE;
                }else{
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<M; i++){
            for(int j=0; j<3; j++){
                res = Math.min(res, dp[N-1][i][j]);
            }
        }
        System.out.println(res);
    }
}
