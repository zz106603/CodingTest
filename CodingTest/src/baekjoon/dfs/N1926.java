package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1926 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;
	static int[][] map;
	static int row, col, count;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		visited = new boolean[row][col];
		map = new int[row][col];
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					count++;
					dfs(i, j, 1);
				}
			}
		}
		
		bw.write(count + "\n" + max);
		bw.flush();
		bw.close();
		
	}
	
	public static void dfs(int x, int y, int count) {
		
		if(max < count) {
			max = count;
		}
		
		for(int k=0; k<4; k++) {
			int nx = dx[k] + x;
			int ny = dy[k] + y;
			if(nx>=0 && nx<row && ny>=0 && ny<col && !visited[nx][ny]) {
				if(map[nx][ny] == 1) {
					visited[nx][ny] = true;
					dfs(nx, ny, count+1);
				}
			}
		}
		
		
	}
}
