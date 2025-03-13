package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*
        한 명씩 앉을 수 있는 테이블이 행마다 W개씩 H행에 걸쳐 있을 때,
        모든 참가자는 세로로 N칸 또는 가로로 M칸 이상 비우고 앉아야 한다.
        즉, 다른 모든 참가자와 세로줄 번호의 차가 N보다 크거나 가로줄 번호의 차가 M보다 큰 곳에만 앉을 수 있다.
        5 4 1 1
         */

        int col = (H-1)/(N+1) + 1;
        int row = (W-1)/(M+1) + 1;
        System.out.println(col*row);
    }
}
