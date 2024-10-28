package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N15903 {
	
	/*
	 * https://www.acmicpc.net/problem/15903
	 * Array.sort를 사용하는 것 보다 우선순위 큐를 사용하면 성능 향상
	 * 
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> q = new PriorityQueue<>();
//		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
			q.add(Long.parseLong(st.nextToken()));
		}
		
		int cnt = 0;
		while(cnt < m) {
			long plus = q.poll() + q.poll();
			q.add(plus);
			q.add(plus);
			cnt++;
		}
		
//		for(int i=0; i<m; i++) {
//			Arrays.sort(arr);
//			long plus = arr[0] + arr[1];
//			arr[0] = plus;
//			arr[1] = plus;
//		}
		
		long answer = 0;
		while(!q.isEmpty()) {
			answer += q.poll();
		}
//		for(long num : arr) {
//			answer += num;
//		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();

	}

}
