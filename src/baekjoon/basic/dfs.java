package baekjoon.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs {

	

	/*
	 * 그림 개수, 가장 넓은 그림
	 * 모든 경로 탐색
	 */
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visit;
	static int[][] arr;
	static int row, col;
	static int count;
	static int max = Integer.MIN_VALUE;
	
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
					dfs(i, j, 1);
				}
			}
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int x, int y, int area) {
		
		if(max < area) {
			max = area;
		}
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx>=0 && nx<row && ny>=0 && ny<col && !visit[nx][ny]) {
				if(arr[nx][ny] == 1) {
					visit[nx][ny] = true;
					dfs(nx, ny, area+1);
				}
			}
		}
		
	}

}
