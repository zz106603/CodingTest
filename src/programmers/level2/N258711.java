package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class N258711 {

	
	/*		in	out
	 * 정점	0	>1
	 * 도넛	>=1	1
	 * 막대	>=1	0
	 * 8자	>=2	2
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, 
				{4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
		
		
		Map<Integer, Integer> out = new HashMap<>();
		Map<Integer, Integer> in = new HashMap<>();
		int[] answer = new int[4];
		
		for(int[] edge : edges) {
			out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
			in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
		}
		
		for(int node : out.keySet()) {
			if(out.get(node) > 1) {
				if(!in.containsKey(node)) {
					answer[0] = node;
				}else {
					answer[3] += 1;
				}
			}
		}
		
		for(int node : in.keySet()) {
			if(!out.containsKey(node)) {
				answer[2] += 1;
			}
		}
		
		answer[1] = out.get(answer[0]) - answer[2] - answer[3];
		
		for(int val : answer) {
			System.out.print(val + " ");
		}

	}

}
