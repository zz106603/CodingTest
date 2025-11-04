package baekjoon.random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1303 {
    static int N, M;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = c[j];
            }
        }

        int[] ans = new int[2];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visit[i][j]){
                    int total = bfs(i, j, map[i][j]);
                    if(map[i][j] == 'W'){
                        ans[0] += total*total;
                    }else{
                        ans[1] += total*total;
                    }
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);

    }
    public static int bfs(int x, int y, char team){
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{x, y});
        visit[x][y] = true;
        int total = 1;

        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int k=0; k<4; k++){
                int nx = dx[k] + cx;
                int ny = dy[k] + cy;
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny] && map[nx][ny] == team) {
                    total++;
                    visit[nx][ny] = true;
                    qu.add(new int[]{nx, ny});
                }
            }
        }

        return total;
    }
}
