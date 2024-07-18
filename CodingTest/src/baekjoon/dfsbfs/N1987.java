package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N1987 {

	/*
	 * https://www.acmicpc.net/problem/1987
	 */
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int row;
	static int col;
	static boolean[] visited;
	static HashSet<String> alp;
	static int[][] arr;
	static int max = 1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		visited = new boolean[26];
		alp = new HashSet<>();
		
		arr = new int[row][col];
		
		for(int i=0; i<row; i++) {
			String str = br.readLine();
			for(int j=0; j<col; j++) {
				arr[i][j] = str.charAt(j) - 'A';
			}
		}
		
		dfs(0, 0, 0);
		
		System.out.println(max);

	}
	
	public static void dfs(int x, int y, int count) {

		if(visited[arr[x][y]]) {
			max = Math.max(max, count);
			return;
		}
		
		visited[arr[x][y]] = true;
		
		for(int K=0; K<4; K++) {
			int nx = dx[K] + x;
			int ny = dy[K] + y;
			if(nx>=0 && nx<row && ny>=0 && ny<col) {
				dfs(nx, ny, count+1);
			}
		}
		
		visited[arr[x][y]] = false;
	}
	
}
