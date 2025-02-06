package programmers.dfsbfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class N1844 {
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visit;

	public static void main(String[] args) throws IOException{
		int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1},{1,1,1,0,1}, {0,0,0,0,1}};
		visit = new boolean[maps.length][maps[0].length];
		int result = bfs(maps, 0, 0);

		System.out.println(result);
	}

	public static int bfs(int[][] maps, int x, int y){
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[]{x, y, 1}); // 1은 dist
		visit[x][y] = true;

		while(!qu.isEmpty()){
			int[] cur = qu.poll();
			int cx = cur[0];
			int cy = cur[1];
			int dist = cur[2];

			if(cx == maps.length-1 && cy == maps[0].length-1) return dist;

			for(int k=0; k<4; k++){
				int nx = dx[k] + cx;
				int ny = dy[k] + cy;
				if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length){
					if(!visit[nx][ny] && maps[nx][ny] == 1){
						qu.add(new int[]{nx, ny, dist+1});
						visit[nx][ny] = true;
					}
				}
			}
		}
		return -1;
	}
}
