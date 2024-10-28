package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N10971 {

	/*
	 * https://www.acmicpc.net/problem/10971
	 */
	
	static int[][] map;
	static boolean[] visit;
	static int n;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			visit[i] = true;
			dfs(i, i, 0, 0);
		}
		
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		
	}
	
	/*
	 * start: 시작 도시 위치
	 * now: 현재 도시 위치
	 * depth: 모든 도시를 지나가야 함
	 * cost: 이동 비용
	 */
	public static void dfs(int start, int now, int depth, int cost) {
		if(depth == n-1) {
			if(map[now][start] != 0) { //도시 -> 도시로 갈 수 없는 경우도 있음
				cost += map[now][start];
				min = Math.min(min, cost);
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visit[i] && map[now][i] > 0) { //경로가 존재하면 이동 ex)now를 0에서 1로 변경
				visit[i] = true;
				dfs(start, i, depth+1, cost+map[now][i]);
				visit[i] = false;
			}
		}
	}
}
