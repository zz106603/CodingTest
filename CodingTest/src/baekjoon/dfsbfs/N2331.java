package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N2331 {

	/*
	 * https://www.acmicpc.net/problem/2331
	 * 
	 * 1. 계산되는 수열 값을 배열에 [값] = true로 저장
	 * 2. 계산되는 수열 값을 리스트에 저장
	 * 3. true를 만나게되면 반복 수열 시작, 값을 basic변수에 저장, break
	 * 4. 리스트 basic값의 index위치를 찾아서 반환
	 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new LinkedList<>();
		boolean[] visit = new boolean[250000];
		
		int basic = start;
		list.add(start);
		visit[start] = true;
		
		while(true) {
			String[] str = String.valueOf(start).split("");
			int sum = 0;
			for(int i=0; i<str.length; i++) {
				sum += (int)Math.pow(Double.parseDouble(str[i]), p); 
			}
			if(!visit[sum]) {
				visit[sum] = true;
				list.add(sum);
				start = sum;
			}else {
				basic = sum;
				break;
			}
		}
		bw.write(String.valueOf(list.indexOf(basic)));
		bw.flush();
		bw.close();
	}
	
	
}
