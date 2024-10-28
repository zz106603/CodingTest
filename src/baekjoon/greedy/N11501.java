package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11501
 * 
 * 뒤에서부터 기준값보다 큰 값이 나올때까지 뺄샘 후 결과에 합해주면 됨
 */

public class N11501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int arr[] = new int[n];
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			
			int max = arr[n-1];
			
			for(int j=n-2; j>=0; j--) {
				if(arr[j] <= max) {
					answer += max - arr[j];					
				}else {
					max = arr[j];
				}
			}
			bw.append(answer + "\n");
		}
		
		bw.flush();
		bw.close();

	}

}
