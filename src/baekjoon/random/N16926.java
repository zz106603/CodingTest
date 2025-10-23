package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // N, M중에 최소값을 2로 나누면 테두리 개수가 나옴
        int layers = Math.min(N, M) / 2;

        for(int r=0; r<R; r++){
            for(int layer=1; layer<=layers; layer++){
                int startX = layer;
                int startY = layer;
                int endX = N - layer + 1;
                int endY = M - layer + 1;

                int temp = map[startX][startY];

                // 오른쪽 위 ← 왼쪽 위로
                for (int i = startY; i < endY; i++) {
                    map[startX][i] = map[startX][i + 1];
                }

                // 오른쪽 아래 ← 오른쪽 위로
                for (int i = startX; i < endX; i++) {
                    map[i][endY] = map[i+1][endY];
                }

                // 왼쪽 아래 ← 오른쪽 아래로
                for (int i = endY; i > startY; i--) {
                    map[endX][i] = map[endX][i - 1];
                }

                // 왼쪽 위 ← 왼쪽 아래로
                for (int i = endX; i > startX + 1; i--) {
                    map[i][startY] = map[i - 1][startY];
                }

                map[startX + 1][startY] = temp; // 임시 저장값 복원
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}

/*
A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
   ↓                                       ↑
A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
   ↓         ↓                   ↑         ↑
A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
   ↓                                       ↑
A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]

N: 4, M: 5
1, 1
4, 5
1) [1~4][1]까지 x를 증가
2) [4][1~4]까지 y를 증가
3) [4~1][5]까지 x를 감소
4) [1][5~1]까지 y를 감소

2, 2
3, 4
1) [2~3][2]까지 x를 증가
2) [3][2~4]까지 y를 증가
3) [3~2][4]까지 x를 감소
4) [2][4~2]까지 y를 감소

1  2  3  4
7  8  9  10
13 14 15 16
19 20 21 22
25 26 27 28

2  3  4  10
1  9  15 16
7  8  21 22
13 20 14 28
19 25 26 27

 */