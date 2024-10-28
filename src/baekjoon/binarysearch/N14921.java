package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N14921 {

	/*
	 * https://www.acmicpc.net/problem/14921
	 * 
	 * 1. 조합으로 먼저 풀어봤지만, 약 50억개의 조합이 생성되어 메모리 초과가 발생
	 * 2. 정렬된 배열에서 2개의 수로 조작하는거니까 투포인터 사용
	 * 
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
		
		int left = 0;
		int right = n-1;
		int min = Integer.MAX_VALUE;
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(Math.abs(min) > Math.abs(sum)) {
				min = sum;
			}
			
			if(sum < 0) {
				left++;
			}else {
				right--;
			}
			
		}
		
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		
		/* 조합으로 시도한 방법
		List<List<Integer>> result = combine(arr, 2);
		
		long min = 200000001;
		long res = 0;
		
		for(List<Integer> list : result) {
			
			long sum = 0;
			for(Integer val : list) {
				sum += val;
			}
			
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				res = sum;
			}
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		 
		 
		 */
		
		
	}
	
	public static List<List<Integer>> combine(int[] arr, int k){
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), arr, k, 0); //0은 start
		return result;
	}
	
	public static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] arr, int k, int start) {
		if(temp.size() == k) {
			result.add(new ArrayList<>(temp));
		}else {
			for(int i=start; i<arr.length; i++) {
				temp.add(arr[i]);
				backtrack(result, temp, arr, k, i+1);
				temp.remove(temp.size()-1);
			}
		}
	}
}
