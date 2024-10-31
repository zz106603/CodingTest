package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class N147354 {

	public static void main(String[] args) {
		
		int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
		int col = 2 ;
		int row_begin = 2;
		int row_end = 3;
		
		Arrays.sort(data, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[col-1] != b[col-1]) {
					return Integer.compare(a[col-1], b[col-1]);
				}
				return Integer.compare(b[0], a[0]);
			}
		});
		
		for(int[] arr : data) {
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
		
		
		

	}

}
