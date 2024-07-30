package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N6593 {
	
	/*
	 * https://www.acmicpc.net/problem/6593
	 * 
	 * 3차원 배열을 사용한 BFS
	 */

	static int l ,r, c, count;
	static char[][][] arr;
	static boolean[][][] visit;
	static int[] dx = {0, 0, 0, 0, 1, -1};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {1, -1, 0, 0, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(l == 0 && r == 0 && c == 0) {
				bw.flush();
				bw.close();
				return;
			}
			
			count = 0;
			arr = new char[l][r][c];
			visit = new boolean[l][r][c];
			
			for(int i=0; i<l; i++) {
				for(int j=0; j<r; j++) {
					char[] input = br.readLine().toCharArray();
					for(int k=0; k<c; k++) {
						 arr[i][j][k] = input[k];
					}
				}
				br.readLine();
			}
			
			for(int i=0; i<l; i++) {
				for(int j=0; j<r; j++) {
					for(int k=0; k<c; k++) {
						 if(arr[i][j][k] == 'S') {
							 bfs(i, j, k);
						 }
					}
				}
			}
			
			if(count == 0) {
				bw.write("Trapped!\n");
			}else {
				bw.write("Escaped in " + count + " minute(s).\n");	
			}
			
		}
		
	}
	
	public static void bfs(int x, int y, int z) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {x, y, z, 0});
		visit[x][y][z] = true;
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			int cx = cur[0];
			int cy = cur[1];
			int cz = cur[2];
			int move = cur[3];
			
			if(arr[cx][cy][cz] == 'E') {
				count = move;
				return;
			}
			
			for(int k=0; k<6; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				int nz = cz + dz[k];
				
				if(nx>=0 && nx<l && ny>=0 && ny<r && nz>=0 && nz<c) {
					if(!visit[nx][ny][nz]) {
						if(arr[nx][ny][nz] == '.' || arr[nx][ny][nz] == 'E') {
							qu.add(new int[] {nx, ny, nz, move+1});
							visit[nx][ny][nz] = true;
						}
					}
				}
			}
		}
	}
}
