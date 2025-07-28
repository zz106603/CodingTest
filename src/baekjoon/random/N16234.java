package baekjoon.random;

import java.io.*;
import java.util.*;

public class N16234 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;
    static int N, L, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        /*
            1. 국경선 공유 인구 차이가 L 이상, R 이하라면 국경선을 연다
            2. 국경선이 모두 열리면 인구 이동 시작
            3. 이동할 수 있다면 연합이라고 부름
            4. 연합을 이루는 각 칸의 인구수는 (연합의 인구수 / 연합을 이루고 있는 칸의 개수), 소수점은 버림
            5. 연합을 해체하고 국경선을 닫는다.

            인구 이동이 며칠동안 발생하는가?
         */

        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        // 일일
        while(true){
            visit = new boolean[N][N];
            boolean moved = false;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j]){
                        List<int[]> curUnion = new ArrayList<>();
                        int total = bfs(i, j, curUnion);

                        if(curUnion.size() > 1){
                            moved = true;
                            int avg = total / curUnion.size();
                            for(int[] c : curUnion){
                                arr[c[0]][c[1]] = avg;
                            }
                        }
                    }
                }
            }

            if(!moved) break;
            answer++;

//            for(int i=0; i<N; i++){
//                for(int j=0; j<N; j++){
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        System.out.println(answer);

        // 차이를 구해서 차이가 L 이상 R 이하면 연합의 개수++, total에 모든 값을 더한다. 그리고 위치 쌍도 저장하자.
        // 구했으면 total/연합의 개수 해서 열려있는 곳에 값으로 집어 넣는다.
    }

    public static int bfs(int x, int y, List<int[]> curUnion){
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{x, y, arr[x][y]});

        curUnion.add(new int[]{x, y});
        visit[x][y] = true;
        int sum = arr[x][y];

        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int curX = cur[0];
            int curY = cur[1];
            int citizen = cur[2];

            for(int k=0; k<4; k++){
                int nx = dx[k] + curX;
                int ny = dy[k] + curY;
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]){
                    int diff = Math.abs(citizen - arr[nx][ny]);
                    if(diff >= L && diff <= R){
                       visit[nx][ny] = true;
                       sum += arr[nx][ny];
                       curUnion.add(new int[]{nx, ny});
                       qu.add(new int[]{nx, ny, arr[nx][ny]});
                    }
                }
            }
        }
        return sum;
    }
}
