package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N67257 {

	public static void main(String[] args) {
		String[] arr = {"*", "+", "-"};
		List<List<String>> result = getPermute(arr, 3);

		List<String> strList = new ArrayList<>();
		List<Integer> numList = new ArrayList<>();

		String expression = "100-200*300-500+20";
//		String expression = "50*6-3*2";

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<expression.length(); i++){
			if(expression.charAt(i) == '*' || 
					expression.charAt(i) == '+'|| 
					expression.charAt(i) == '-') {

				strList.add(String.valueOf(expression.charAt(i)));
				numList.add(Integer.parseInt(sb.toString()));
				sb = new StringBuilder();
			}else{
				sb.append(String.valueOf(expression.charAt(i)));
			}

			if(i == expression.length()-1){
				numList.add(Integer.parseInt(sb.toString()));
			}
		}

		List<String> list = new LinkedList<>();
		list.add("*");
		list.add("+");
		list.add("-");

		for(int k=0; k<3; k++) {
			for(int i=0; i<strList.size(); i++){
				if(strList.get(i).equals(list.get(k))){
					int res = 0;
					if(strList.get(i).equals("*")){
						res = numList.get(i)*numList.get(i+1);
						strList.remove(i);
						numList.remove(i);
						numList.remove(i);
						numList.add(i, res);
					}else if(strList.get(i).equals("+")){
						res = numList.get(i) + numList.get(i+1);
						strList.remove(i);
						numList.remove(i);
						numList.remove(i);
						numList.add(i, res);
					}else if(strList.get(i).equals("-")){
						res = numList.get(i) - numList.get(i+1);
						strList.remove(i);
						numList.remove(i);
						numList.remove(i);
						numList.add(i, res);
					}

				}
				System.out.println(strList.toString());
		        System.out.println(numList.toString());
//				strList.remove(i);
			}
//			list.remove(0);
			
			
//	        System.out.println(strList.toString());
//	        System.out.println(numList.toString());
		        
		}
		

	}

	public static List<List<String>> getPermute(String[] arr, int k){
		List<List<String>> result = new ArrayList<>();
		permute(result, new ArrayList<>(), arr, k, new boolean[arr.length]);
		return result;
	}

	public static void permute(List<List<String>> result, List<String> tempList, String[] arr, int k, boolean[] used){
		if(tempList.size() == k){
			result.add(new ArrayList<>(tempList));
			return;
		}

		for(int i=0; i<arr.length; i++){
			if(used[i]) continue;
			used[i] = true;
			tempList.add(arr[i]);
			permute(result, tempList, arr, k, used);
			tempList.remove(tempList.size()-1);
			used[i] = false;
		}
	}

}
