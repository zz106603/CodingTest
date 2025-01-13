package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1926DFS {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] arr;
	static boolean[][] visit;
	static int n, m;
	static int max = 0;
	static int area = 0;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visit[i][j] && arr[i][j] == 1) {
					area = 0;
					dfs(i, j);
					count++;
					max = Math.max(max, area);
				}
			}
		}
		
		bw.write(count+"\n");
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();

	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		area++;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(nx>=0 && nx<n && ny>=0 && ny<m) {
				if(!visit[nx][ny] && arr[nx][ny] == 1) {
					dfs(nx, ny);
				}
			}
		}
	}

}
