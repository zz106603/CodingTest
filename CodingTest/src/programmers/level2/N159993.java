package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class N159993 {
	
	/*
	 * S부터 L까지의 최단 거리
	 * +
	 * L부터의 E까지의 최단 거리
	 * 
	 * 2번의 BFS를 통해 최단 경로를 찾아야 함
	 * 최단 경로를 찾기 위해서는 Queue를 poll()하고 나면 Queue에 담긴 개수 만큼 for문을 통해 다 돌고 나면 층별로 탐색(dist += 1)
	 */

	static String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visit;
	static String[][] arr;
	static int count = 0;
	static boolean flag = false;
	static int sx = 0, sy = 0;
	
	public static void main(String[] args) {
		
		
		arr = new String[maps.length][maps[0].length()];
	    visit = new boolean[maps.length][maps[0].length()];
		
		for(int i=0; i<maps.length; i++) {
			String[] s = maps[i].split("");
			for(int j=0; j<s.length; j++) {
				arr[i][j] = s[j];
				if(arr[i][j].equals("S")) {
					sx = i;
					sy = j;
				}
			}
		}
		
        int lCount = bfs(sx, sy, "L");
        if(lCount == -1){
            System.out.println(-1);
        }
        
        int eCount = bfs(sx, sy, "E");
        if(eCount == -1){
        	System.out.println(-1);
        }
        
        System.out.println(lCount + eCount);

	}
	
	public static int bfs(int x, int y, String target) {
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[arr.length][arr[0].length];
        q.add(new int[]{x, y});
        visit[x][y] = true;

        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) { //이 부분이 중요함, 층마다 거리를 늘려야 하기 때문에 인접한 이동 가능한 위치에 다 이동하면 거리 증가
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];

                // 목표 지점에 도달했을 경우 거리 반환
                if (arr[cx][cy].equals(target)) {
                    sx = cx;
                    sy = cy;
                    return distance;
                }

                // 4방향 탐색
                for (int k = 0; k < 4; k++) {
                    int nx = cx + dx[k];
                    int ny = cy + dy[k];

                    // 범위 내에 있고 방문하지 않았으며 통로일 경우
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                        if (!visit[nx][ny] && !arr[nx][ny].equals("X")) {
                            visit[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            distance++;  // 한 층의 탐색이 끝날 때마다 거리 증가
        }
        // 목표 지점에 도달할 수 없을 경우
        return -1;
    }

}
