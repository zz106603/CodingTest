package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2805 {
	
	/*
	 * https://www.acmicpc.net/problem/2805
	 * 
	 * 절단기의 높이 x를 구해서 나무 m미터를 가져갈 수 있는지 판단 -> 이진 탐색
	 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long max = 0;
		
		/*
		 * left와 right를 더했을 때, 
		 */
		long left = 0;
		long right = arr[n-1];
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			long count = 0;
			for(int i=0; i<n; i++) {
				if(arr[i] > mid) {
					count += arr[i] - mid;
				}
			}
			
			if(count >= m) { //가져갈 나무가 많으면, 절단기를 더 높이
				max = Math.max(max, mid);
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		
	}

}
