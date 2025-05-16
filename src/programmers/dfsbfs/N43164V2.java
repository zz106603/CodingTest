package programmers.dfsbfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N43164V2 {
	
	static List<String> answer;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		
		String[][] tickets = {
	            {"ICN", "SFO"},
	            {"ICN", "ATL"},
	            {"SFO", "ATL"},
	            {"ATL", "ICN"},
	            {"ATL", "SFO"}
	        };

		Arrays.sort(tickets, (a, b) -> {
			return a[1].compareTo(b[1]);
		});
		
		visit = new boolean[tickets.length];
		answer = new ArrayList<>();

		List<String> path = new ArrayList<>();
		path.add("ICN");

		dfs("ICN", path, tickets, 0);

		for(String val : answer.toArray(new String[0])){
			System.out.print(val+ " ");
		}
	}

	public static void dfs(String start, List<String> path, String[][] tickets, int count) {
		/*
		 	tickets를 정렬한 상태로 dfs를 시작했기 때문에 가장 먼저 찾은 경로가 정답이 됨
		 	정답을 찾으면 dfs를 더 돌릴 필요가 없기 때문에 아래 로직을 수행하지 않도록 바로 return (dfs를 빠져나간다고 표현함)
		 	visit같은 경우는 i를 통해 탐색했던 경로인지를 판단하자.
		 */
		if(!answer.isEmpty()) return;

		if(count == tickets.length) {
			answer = new ArrayList<>(path);
			return;
		}
		
		for(int i=0; i<tickets.length; i++) {
			if(start.equals(tickets[i][0]) && !visit[i]) {
				visit[i] = true;
				path.add(tickets[i][1]);
				dfs(tickets[i][1], path, tickets, count+1);
				path.remove(path.size()-1);
				visit[i] = false;
			}
		}
	}
}
