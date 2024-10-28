package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N10451 {
	
	/*
	 * https://www.acmicpc.net/problem/10451
	 */

	static int[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int count = 1;
			int m = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[m+1];
			visit = new boolean[m+1];
			
			//arr[1 ~ m] 저장
			for(int j=1; j<=m; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			visit[1] = true;
			dfs(arr[1]);
			for(int j=2; j<=m; j++) {
				if(!visit[j]) {
					count++;
					dfs(arr[j]);
				}
			}
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	
	public static void dfs(int num) {
		if(!visit[num]) {
			visit[num] = true;
			dfs(arr[num]);
		}
	}

}
