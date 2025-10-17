package baekjoon.random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7576 {
    static int[][] map;
    static boolean[][] visit;
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> qu = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1){
                    visit[i][j] = true;
                    qu.add(new int[]{i, j});
                }
            }
        }

        bfs(qu);

        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(map[i][j], max);
            }
        }

        System.out.println(max-1);

    }

    static void bfs(Queue<int[]> qu){
        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int k=0; k<4; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != -1){
                    if(!visit[nx][ny]){
                        visit[nx][ny] = true;
                        if(map[nx][ny] == 0){
                            map[nx][ny] = map[cx][cy] + 1;
                        }else{
                            map[nx][ny] = Math.min(map[cx][cy] + 1, map[nx][ny]);
                        }
                        qu.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
