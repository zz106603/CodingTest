package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1920 {
	
	/*
	 * https://www.acmicpc.net/problem/1920
	 * 
	 * 이분 탐색시 주의사항
	 * - 배열을 가지고 mid를 구한 후, arr[mid] 값으로 비교
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
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			//값은 1 ~ N이지만 인덱스는 0 ~ N-1
			int min = 0;
			int max = n-1;
			
			if(binarySearch(arr, num, min, max) > 0) {
				bw.write(1 + "\n");
			}else {
				bw.write(0 + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int binarySearch(int[] arr, int num, int min, int max) {
		
		while(min <= max) {
			int mid = (min + max) / 2;
			if(arr[mid] > num){
				max = mid - 1;
			}else if(arr[mid] < num) {
				min = mid + 1;
			}else {
				return 1;
			}
		}
		return 0;
	}
}
