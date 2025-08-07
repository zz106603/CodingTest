package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N10844 {

    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
            45656이란 수를 보자. 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
            N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

            예를 들어 n이 2라고 하면 길이가 2인 것 즉, 12, 21, 35, 75, 96 이런걸 말하고 01 이런건 아님
            1 <= N <= 100

            - DP 정의
            dp[i][j] = i자리 계단 수 중 마지막 숫자가 j인 것의 개수
            i: 자릿수(1~N)
            j: 마지막 자리 숫자(0~9)

            - 초기값
            1자리 수는 1~9가 각각 1개씩 존재 dp[1][1~9] = 1, dp[1][0] = 0

            - 점화식
            마지막 자리가 0이면, 그 앞자리는 1밖에 못옴 => dp[i][0] = dp[i-1][1]
            마지막 자리가 9면, 그 앞자리는 8밖에 못옴 => dp[i][9] = dp[i-1][8]
            나머지는 1차이 나는 두 숫자에서 옴 => dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] (1 <= j <= 8)
         */
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        // 1자리 수 초기값 세팅
        for(int j=1; j<=9; j++){
            dp[1][j] = 1;
        }

        // 2자리부터 N자리까지 계산
        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][1];
                }else if(j == 9){
                    dp[i][j] = dp[i-1][8];
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
                }
            }
        }

        long answer = 0;
        for(int j=0; j<=9; j++){
            answer = (answer + dp[N][j]) % MOD;
        }

        System.out.println(answer);
    }
}
