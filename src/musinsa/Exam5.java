package musinsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam5 {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    static char[][] arr;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
            N x M 격자
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                arr[i][j] = input[j];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 'S'){
                    bfs(i, j);
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    public static void bfs(int x, int y){
        Queue<int[]> qu = new ArrayDeque<>();
        qu.add(new int[]{x, y, 0});
        visit[x][y] = true;

        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int curX = cur[0];
            int curY = cur[1];
            int dist = cur[2];

            if(arr[curX][curY] == 'E'){
                ans = dist;
                break;
            }

            for(int k=0; k<4; k++){
                int nx = dx[k] + curX;
                int ny = dy[k] + curY;
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visit[nx][ny] && arr[nx][ny] != '1'){
                        visit[nx][ny] = true;
                        qu.add(new int[]{nx, ny, dist+1});
                    }
                }
            }
        }

    }
}
