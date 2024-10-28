package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1389 {
	
	/*
	 * https://www.acmicpc.net/problem/1389
	 * 
	 * 플로이드-워셜 알고리즘(노드 수가 일반적으로 100개 이하)
	 * 
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				arr[i][j] = 987654321;
				if(i == j) {
					arr[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		int max = 987654321;
		int result = 0;
		for(int i=1; i<=n; i++) {
			int total = 0;
			for(int j=1; j<=n; j++) {
				total += arr[i][j];
			}
			if(max > total) {
				max = total;
				result = i;
			}
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		
		
	}
}
