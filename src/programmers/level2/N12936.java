package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class N12936 {
	
	/*
	 * 기존 순열 알고리즘을 사용하면 메모리 초과가 생김
	 * 1, 2, 3
	 * 1, 3, 2
	 * -------
	 * 2, 1, 3
	 * 2, 3, 1
	 * -------
	 * 3, 1, 2
	 * 3, 2, 1
	 * 
	 * 첫 번째 자리에 들어갈 수 있는 수 n개
	 * 두 번째 자리에 들어갈 수 있는 수 n-1개
	 * 세 번째 자리에 들어갈 수 있는 수 n-2개
	 * 
	 * factorial을 n으로 나누어서 경우의 수를 찾음
	 * 처음 경우의 수는 2이기 때문에 
	 * 
	 */

	public static void main(String[] args) {
		
		int n = 3; 
		long k = 5;
		
		int[] answer = new int[n];
		
		List<Integer> list = new ArrayList<>();
		long factorial = 1;
		int index = 0;
		
		for(int i=1; i<=n; i++) {
			factorial *= i;
			list.add(i);
		}
		
		k--;
		while(n > 0) {
			factorial /= n;
			int value = (int)(k/factorial);
			answer[index++] = list.get(value);
			list.remove(value);
			
			k %= factorial;
			n--;
		}
		
		for(int val : answer) {
			System.out.print(val + " ");
		}
		

	}

}
