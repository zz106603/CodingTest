package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class N18869 {
	
	/*
	 * https://www.acmicpc.net/problem/18869
	 * 
	 * 1. 각 행성들의 순위를 매긴다.
	 * 2. 순위를 매기기 위해서는 좌표 압축을 사용(정렬된 리스트를 가지고 기존 값으로 인덱스를 찾아 순위를 반환하는 방법)
	 * 
	 * 키포인트는 Set을 사용한 정렬된 리스트를 이용해서 이진 탐색을 통해 인덱스로 순위를 알아내는 것
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[m][n];
		List<Integer>[] sortedArr = new ArrayList[m];
		
		for(int i=0; i<m; i++) {
			Set<Integer> set = new HashSet<>(); //중복 값을 삭제하기 위해
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				set.add(num);
			}
			
			//좌표 압축을 하기 위해서 값들을 일단 정렬 -> 정렬을 해야 값을 찾았을 때 인덱스를 가지고 순위를 매길 수 있음
			sortedArr[i] = new ArrayList<>(set);
			Collections.sort(sortedArr[i]);
		}
		
		int[][] compressArr = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				compressArr[i][j] = binarySearch(sortedArr[i], arr[i][j]); //이진 탐색으로 순위 저장
			}
		}

		int count = 0;
		for(int i=0; i<m; i++) {
			for(int j=i+1; j<m; j++) {
				if(Arrays.equals(compressArr[i], compressArr[j])) {
					count++;
				}
			}
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		
	}
	
	/*
	 * List.indexOf(val) -> O(n)
	 * binarySearch -> O(logN)
	 */
	public static int binarySearch(List<Integer> sortedArr, int val) {
		
		int left = 0;
		int right = sortedArr.size()-1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(sortedArr.get(mid) == val) {
				return mid;
			}
			if(sortedArr.get(mid) < val) { //값이 mid인덱스 값보다 뒤에 있기에 시작지점을 mid+1로
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		return -1;
		
	}
}
