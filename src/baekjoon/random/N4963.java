package baekjoon.random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N4963 {
    static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            int[][] map = new int[N][M];
            boolean[][] visit = new boolean[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(!visit[i][j] && map[i][j] == 1){
                        ans++;
                        bfs(map, visit, i, j, N, M);
                    }
                }
            }

            bw.write(ans+"\n");
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(int[][] map, boolean[][] visit, int x, int y, int N, int M){
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{x, y});
        visit[x][y] = true;

        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int k=0; k<8; k++){
                int nx = dx[k] + cx;
                int ny = dy[k] + cy;
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visit[nx][ny] && map[nx][ny] == 1){
                        qu.add(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
}
