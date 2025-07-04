package programmers.random;

import java.util.LinkedList;
import java.util.Queue;

public class N1844 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit = new boolean[5][5];
    static int[][] maps = {
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,1},
            {0,0,0,0,1}
    };

    public static void main(String[] args){

        int answer = bfs(0, 0);
        System.out.println(answer);

    }

    public static int bfs(int x, int y){
        Queue<int[]> qu = new LinkedList<>();
        visit[x][y] = true;
        qu.add(new int[]{x, y, 1});

        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int curX = cur[0];
            int curY = cur[1];
            int count = cur[2];

            if(curX == 4 && curY == 4){
                return count;
            }

            for(int k=0; k<4; k++){
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5){
                    if(!visit[nx][ny] && maps[nx][ny] == 1){
                        qu.add(new int[]{nx, ny, count + 1});
                        visit[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }
}
