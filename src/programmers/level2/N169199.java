package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class N169199 {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] visit;
	static int answer = -1;
	
	public static void main(String[] args) {
		String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
		
		visit = new int[board.length][board[0].length()];
		
		for(int i=0; i<board.length; i++) {
			String[] str = board[i].split("");
			for(int j=0; j<str.length; j++) {
				if(str[j].equals("R")) {
					bfs(i, j, board);
				}
			}
		}
		
		System.out.println(answer);

	}
	
	public static void bfs(int x, int y, String[] board) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			if(board[cx].charAt(cy) == 'G') {
				answer = visit[cx][cy] - 1;
				break;
			}
			
			for(int k=0; k<4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				while(true) {
					if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length() && board[nx].charAt(ny) != 'D') {
						nx += dx[k];
						ny += dy[k];
					}else {
						nx -= dx[k];
						ny -= dy[k];
						break;
					}
				}
				
				if(visit[nx][ny] == 0) {
					q.add(new int[] {nx, ny});
					visit[nx][ny] = visit[cx][cy] + 1;
				}
			}
		}
	}

}
