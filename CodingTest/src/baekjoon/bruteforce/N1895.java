package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N1895 {
	
	/*
	 * https://www.acmicpc.net/problem/1895
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[row][col];
		
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++){
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		
		for(int z=0; z<row-2; z++) {
			for(int k=0; k<col-2; k++) {
				List<Integer> li = new ArrayList<>();
				for(int i=z; i<z+3; i++) {
					for(int j=k; j<k+3; j++) {
//						System.out.print(arr[i][j] + " ");
						li.add(arr[i][j]);
					}
//					System.out.println();
				}
				Collections.sort(li);
				res.add(li.get(4));
			}
		}
		
		int result = 0;
		for(int val : res) {
			if(val >= t) {
				result++;
			}
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		

	}
}
