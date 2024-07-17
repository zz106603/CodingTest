package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3};
		int k = 2;
		
		List<List<Integer>> result = combine(numbers, k);
		System.out.println(result.toString());
		
		long result2 = combine(3, 2);
		System.out.println(result2);
	}
	
	/*
	 * 조합
	 */
	public static List<List<Integer>> combine(int[] numbers, int k){
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), numbers, k, 0);
		return result;
	}
	
	public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] numbers, int k, int start){
		if(tempList.size() == k) {
			result.add(new ArrayList<>(tempList));
		}else {
			for(int i=start; i<numbers.length; i++) {
				tempList.add(numbers[i]);
				backtrack(result, tempList, numbers, k, i+1);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	/*
	 * 조합 개수 구하기
	 * 
	 *   n!
	 * -----
	 * k!(n-k)!
	 */
	public static long combine(int n, int k) {
		if(k > n-k) {
			k = n-k;
		}
		
		long result = 1;
		for(int i=0; i<k; i++) {
			result *= (n-i);
			result /= (i+1);
		}
		return result;
	}
	
	

}
