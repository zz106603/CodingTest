package jabda;

import java.util.LinkedList;
import java.util.Queue;

public class Omok {
    static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public static void main(String[] args){

        int[][] B = {{}};
        int[][] W = {{}};

        int[][] map = new int[20][20];
        for (int[] b : B) {
            map[b[0] - 1][b[1] - 1] = 1;
        }
        for (int[] w : W) {
            map[w[0] - 1][w[1] - 1] = 2;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int color = map[i][j];
                if (color != 0) {
                    for (int dir = 0; dir < 8; dir++) {
                        int prevX = i - dx[dir];
                        int prevY = j - dx[dir];
                        if(prevX >= 0 && prevX < 20 && prevY >= 0 && prevY < 20 && map[prevX][prevY] == color){
                            continue;
                        }

                        int count = 1;
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        while(nx >= 0 && nx < 20 && ny >= 0 && ny < 20 && map[nx][ny] == color){
                            count++;
                            nx += dx[dir];
                            ny += dy[dir];
                        }

                        if(count == 5){
                            System.out.println(color == 1 ? 1 : -1);
                            return;
                        }
                    }
                }
            }
        }
    }
}

