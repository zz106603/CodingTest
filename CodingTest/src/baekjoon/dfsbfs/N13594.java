package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N13594 {
	
	/*
	 * https://www.acmicpc.net/problem/13549
	 * 
	 */
	
	static int start, end, second;
	static boolean visit[];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		visit = new boolean[1000001];
		bfs(start);
		
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(int start) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {start, 0});
		visit[start] = true;
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			int val = cur[0];
			int move = cur[1];
			
			visit[val] = true;
			
			if(val == end) {
				min = Math.min(min, move);
			}
			
			if(val*2 <= 1000000 && !visit[val*2]) {
				qu.add(new int[] {val*2, move});
			}
			if(val+1 <= 1000000 && !visit[val+1]) {
				qu.add(new int[] {val+1, move+1});
			}
			if(val-1 >= 0 && !visit[val-1]) {
				qu.add(new int[] {val-1, move+1});
			}
		}
	}

}
