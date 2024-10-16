package baekjoon.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs {

	

	/*
	 * 그림 개수, 가장 넓은 그림
	 * 최소 이동 경로
	 */
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visit;
	static int[][] arr;
	static int row, col;
	static int count, area;
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		arr = new int[row][col];
		visit = new boolean[row][col];
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(arr[i][j] ==1 && !visit[i][j]) {
					count++;
					area = 0;
					bfs(i, j);
					max = Math.max(max, area);
				}
			}
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = true;
		area++;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for(int k=0; k<4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				if(nx>=0 && nx<row && ny>=0 && ny<col) {
					if(arr[nx][ny] == 1 && !visit[nx][ny]) {
						q.add(new int[] {nx, ny});
						visit[nx][ny] = true;
						area++;
					}
				}
			}
		}
	}

}
