package baekjoon.kt;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2178 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;
    static int[][] map;
    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs(0, 0);
    }

    public static void bfs(int x, int y){
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{x, y, 1});
        visit[x][y] = true;

        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int cx = cur[0];
            int cy = cur[1];
            int count = cur[2];

            if(cx == N-1 && cy == M-1){
                System.out.println(count);
                return;
            }

            for(int k=0; k<4; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visit[nx][ny] && map[nx][ny] == 1){
                        visit[nx][ny] = true;
                        qu.add(new int[]{nx, ny, count+1});
                    }
                }
            }
        }
    }
}
