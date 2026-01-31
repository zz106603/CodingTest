package musinsa.gemini;

import java.io.*;
import java.util.StringTokenizer;

public class Exam3V2 {
    static int N, M, r, c, d;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            로봇이 청소한 총 구역 개수
            1. 창고 상태 : NxM, 각 칸은 0(빈 공간) 또는 1(벽)
            2. 로봇의 초기 상태: 로봇은 특정 좌표(r, c)에서 특정 방향 d를 바라보고 시작
            - 방향 d: 0(북), 1(동), 2(남), 3(서)
            3. 작동 순서
            - 현재 칸이 청소되지 않았다면 현재 칸을 청소
            - 현재 바라보는 방향에서 왼쪽 방향으로 90도 회전
            - 회전한 후 바로 앞 칸이 빈 공간(0)이고 아직 청소하지 않은 곳이라면, 한 칸 전진
            - 회전 후, 앞 칸이 이미 청소되었거나 벽(1)이라면, 다시 왼쪽으로 90도 회전하며 청소 가능 구역 찾기 반복
            - 네 방향 모두 이미 청소되었거나 벽이라서 갈 곳이 없다면, 바라보는 방향을 유지한 채로 한 칸 후진(후진하는 칸이 벽이면 작동 멈춤)

11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

57
         */

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new boolean[N][M];

            int answer = 0;

            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            while(true){
                if(!visit[r][c]){
                    answer++;
                    visit[r][c] = true;
                }

                boolean flag = false;
                for(int k=0; k<4; k++){
                    d = (d + 3) % 4;
                    int nR = r + dr[d];
                    int nC = c + dc[d];
                    if(nR >= 0 && nR < N && nC >= 0 && nC < M){
                        if(map[nR][nC] == 0 && !visit[nR][nC]){
                            r = nR;
                            c = nC;
                            flag = true;
                            break;
                        }
                    }
                }

                if(!flag){
                    int nR = r - dr[d];
                    int nC = c - dc[d];
                    if(nR >= 0 && nR < N && nC >= 0 && nC < M){
                        if(map[nR][nC] == 1){
                            break;
                        }else{
                            r = nR;
                            c = nC;
                        }
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.close();
    }
}
