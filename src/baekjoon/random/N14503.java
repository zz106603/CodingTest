package baekjoon.random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N14503 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
        1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
        3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
            1. 반시계 방향으로 90도 회전한다.
            2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            3. 1번으로 돌아간다.

         0 -> 3
         1 -> 0
         2 -> 1
         3 -> 2

         */

        clean(map, x, y, dir);

        System.out.println(ans);
    }

    static void clean(int[][] map, int x, int y, int dir){

        while(true){
            if(map[x][y] == 0){
                ans++;
                map[x][y] = -1;
            }

            boolean found = false;
            for(int k=0; k<4; k++){
                dir = (dir + 3) % 4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    found = true;
                    break;
                }
            }

            if(found) continue;

            int backDir = (dir + 2) % 4;
            int bx = x + dx[backDir];
            int by = y + dy[backDir];

            if(map[bx][by] == 1) break;
            x = bx;
            y = by;

        }
    }
}
