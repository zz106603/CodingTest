package musinsa.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N14503 {
    static int N, M, x, y, d;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
                - 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                - 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
                - 반시계 방향으로 90도 회전한다.
                - 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                - 1번으로 돌아간다.
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while(true){
            if(!visit[x][y]){
                visit[x][y] = true;
                ans++;
            }

            boolean front = false;
            for(int k=0; k<4; k++){
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(map[nx][ny] == 0 && !visit[nx][ny]){
                        x = nx;
                        y = ny;
                        front = true;
                        break;
                    }
                }
            }

            if(!front){
                int nx = x - dx[d];
                int ny = y - dy[d];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(map[nx][ny] == 1){
                        break;
                    }else{
                        x = nx;
                        y = ny;
                    }
                }
            }
        }

        System.out.println(ans);


    }
}
