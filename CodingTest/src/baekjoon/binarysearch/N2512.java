package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2512 {
	
	/*
	 * https://www.acmicpc.net/problem/2512
	 * 
	 * 총 예산이 있고, 특정 상한액 x가 총 예산을 넘지 않는 경우를 찾을 때 -> 이진 탐색
	 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		
		long res = 0;
		
		long left = 1;
		long right = arr[n-1];
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			long total = 0;
			for(int i=0; i<n; i++) {
				if(mid < arr[i]) {
					total += mid;
				}else {
					total += arr[i];
				}
			}
			
			if(total >= m) {
				if(total == m) {
					res = Math.max(res, mid); //total과 같아질 경우에도 추가	
				}
				right = mid - 1;
			}else {
				res = Math.max(res, mid);
				left = mid + 1;
			}
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		
	}

}
