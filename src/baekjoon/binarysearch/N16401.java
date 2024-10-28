package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N16401 {
	
	/*
	 * https://www.acmicpc.net/problem/16401
	 * 
	 * 특정 막대과자 길이가 몇 명한테 나누어 줄 수 있는지 판단
	 * = 막대과자 길이 x가 m명한테 나누어줄 수 있는가? -> 이진 탐색
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[n-1];
		
		while(left <= right) {
			int count = 0;
			int mid = (left + right) / 2;
			
			for(int i=0; i<n; i++) {
				if(arr[i] >= mid) {
					count += arr[i]/mid;
				}
			}
			
			/*
			 * count = 줄 수 있는 사람
			 * m = 줘야하는 사람
			 * 
			 * 줄 수 있는 사람 > 줘야하는 사람이면 left를 증가시켜서 값을 올려서 다시 검사
			 * 
			 */
			if(count >= m) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
		}
		
		bw.write(String.valueOf(right));
		bw.flush();
		bw.close();
	
	}

}
