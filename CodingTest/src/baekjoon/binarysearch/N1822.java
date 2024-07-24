package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N1822 {
	/*
	 * https://www.acmicpc.net/problem/1822
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr2);
		
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int num = arr1[i];
			
			int min = 0;
			int max = m-1;
			
			boolean flag = true;
			while(min <= max) {
				int mid = (min + max) / 2;

				if(arr2[mid] < num) {
					min = mid + 1;
				}else if(arr2[mid] > num) {
					max = mid - 1;
				}else {
					flag = false;
					break;
				}
				
			}
			
			if(flag) {
				res.add(num);
			}
		}
		
		Collections.sort(res);
		bw.write(res.size() + "\n");
		for(int val : res) {
			bw.write(val + " ");	
		}
		
		bw.flush();
		bw.close();
		
		
	}
}
