package programmers.random;

import java.io.IOException;

public class N64062 {
	
	/*
	 * https://school.programmers.co.kr/learn/courses/30/lessons/64062
	 */

	public static void main(String[] args) throws IOException{

		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		int answer = 0;
		
		int min = 0;
		int max = 200000001;
		
		while(min <= max) {
			int mid = (min + max) / 2;
			
			//mid값이 연속으로 k번 불가능한지 확인
			if(check(mid, stones, k)) {
				min = mid + 1;
				answer = mid;
			}else {
				max = mid - 1;
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static boolean check(int mid, int[] stones, int k) {
		
		int count = 0;
		for(int i=0; i<stones.length; i++) {
			if(stones[i] < mid) { //stones[i]가 mid값보다 작으면 불가능 한 것
				count++; //연속된 불가능 확인
				if(count >= k) return false;
			}else {
				count = 0;
			}
		}
		return true;
	}
}
