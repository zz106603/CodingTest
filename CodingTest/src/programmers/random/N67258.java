package programmers.random;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N67258 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] gems = {
//				"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
//				"AA", "AB", "AC", "AA", "AC"
//				"XYZ", "XYZ", "XYZ"
				"ZZZ", "YYY", "NNNN", "YYY", "BBB"
	        };

		int[] result = new int[2];
		
		Set<String> set = new HashSet<>();
		for(String str : gems) {
			set.add(str);
		}
		
		int idx = 0;
		int min = 1000001;
		while(set.size() <= gems.length - idx) {
			
			int start = idx + 1;
			int count = idx;
			Set<String> tmp = new HashSet<>();
			for(int i=idx; i<gems.length; i++) {
				if(!tmp.contains(gems[i])) {
					tmp.add(gems[i]);
				}
				count++;
				if(set.size() == tmp.size()) {
					if(min > count - start) {
						result[0] = start;
						result[1] = count;
						min = count - start;
					}
					break;
				}
			}
			idx++;
			if(idx == gems.length) break;
		}
		
		
		System.out.println(result[0] + ", " + result[1]);
		
	}
	
	/*
	 * 참고 해결 코드
	 */
	
	public int[] solution(String[] gems) {
		//Set으로 종류 개수 저장
		int kind = new HashSet<>(Arrays.asList(gems)).size();
		
		int[] answer = new int[2];
		int min = 1000001;
		int start = 0;
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int end=0; end<gems.length; end++) {
			map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
			
			//start가 1보다 크다면 그 위치는 start가 아님
			while(map.get(gems[start]) > 1) {
				map.put(gems[start], map.get(gems[start]) - 1);
				start++;
			}
			
			if(map.size() == kind && min > (end - start)) {
				min = end - start;
				answer[0] = start + 1;
				answer[1] = end + 1;
			}
		}
		
		return answer;
		
	}
}
