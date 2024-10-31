package programmers.level2;

import java.util.Arrays;

public class N340212 {

	public static void main(String[] args) {
		
		int[] diffs = {1, 5, 3};
		int[] times = {2, 4, 7};
		int limit = 30;
		
		int answer = 0;
		
		int[] temp = diffs.clone();
		Arrays.sort(temp);
		
		long left = 1;
		long right = temp[temp.length-1];
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			long totalTime = 0;
			for(int i=0; i<diffs.length; i++) {
				if(diffs[i] > mid) {
					totalTime += (times[i] + times[i-1])*(diffs[i] - mid) + times[i];
				}else {
					totalTime += times[i];
				}
			}
			
			if(totalTime > limit) {
				left = mid + 1;
			}else {
				right = mid - 1;
				answer = (int)mid;
			}
		}
		
		System.out.println(answer);

	}

}
