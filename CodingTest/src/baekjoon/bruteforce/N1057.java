package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1057 {

	/*
	 * https://www.acmicpc.net/problem/1057
	 * 
	 * N명의 참가자 1~N번 배정
	 * 인접한 번호끼리 대결
	 * 
	 * 라운드 참가자가 홀수라면 마지막 번호는 부전승
	 * 다음 라운드에서는 다시 1번부터(처음 번호의 순서를 유지하면서)
	 * N, 김지민, 임한수
	 * 
	 * 1. 짝수라면 번호에서 2로 나눈다.
	 * 1-1. 홀수라면 번호에서 2를 나누고 1을 더한다.
	 * 2. 값이 같아지면 카운트를 출력한다.
	 *
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int res = 0;
		while(a != b) {
			if(a%2 == 0) {
				a = a/2;
			}else {
				a = a/2 + 1;
			}
			
			if(b%2 == 0) {
				b = b/2;
			}else {
				b = b/2 + 1;
			}
			
			res++;
		}
		
		System.out.println(res);
		
		
		
	}
}
