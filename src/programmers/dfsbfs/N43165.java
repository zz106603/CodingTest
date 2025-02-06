package programmers.dfsbfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N43165 {
	
	static int count = 0;

	public static void main(String[] args) throws IOException{
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 5;
		dfs(numbers, target, 0, 0);
		
	}
	public static void dfs(int[] numbers, int target, int index, int result) {
		if(numbers.length == index){
			if(target == result) count++;
			return;
		}else{
			dfs(numbers, target, index+1, result+numbers[index]);
			dfs(numbers, target, index+1, result-numbers[index]);
		}
	}
}
