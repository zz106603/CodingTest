package programmers.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class N43164 {
	
	static List<List<String>> answer;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		
		String[][] tickets = {
	            {"ICN", "SFO"},
	            {"ICN", "ATL"},
	            {"SFO", "ATL"},
	            {"ATL", "ICN"},
	            {"ATL", "SFO"}
	        };

		Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
		
		visit = new boolean[tickets.length];
		answer = new ArrayList<>();

		List<String> path = new ArrayList<>();
		path.add("ICN");

		dfs("ICN", path, tickets, 0);

		for(String val : answer.get(0).toArray(new String[0])){
			System.out.print(val+ " ");
		}
	}

	public static void dfs(String start, List<String> path, String[][] tickets, int count) {
		if(count == tickets.length) {
			answer.add(new ArrayList<>(path));
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
