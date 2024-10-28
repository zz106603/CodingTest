package programmers.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N43164 {
	
	static List<String> allRoute;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[][] arr = {
	            {"ICN", "SFO"},
	            {"ICN", "ATL"},
	            {"SFO", "ATL"},
	            {"ATL", "ICN"},
	            {"ATL", "SFO"}
	        };
		
		visit = new boolean[arr.length];
		allRoute = new ArrayList<>();
		int cnt = 0;
		
		dfs("ICN", "ICN", arr, cnt);
		Collections.sort(allRoute);
		
		String[] res = allRoute.get(0).split(" ");
		
		for(String s : res) {
			System.out.println(s);
		}
		
	}
	public static void dfs(String start, String route, String[][] arr, int cnt) {
		if(cnt == arr.length) {
			allRoute.add(route);
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(start.equals(arr[i][0]) && !visit[i]) {
				visit[i] = true;
				dfs(arr[i][1], route + " " + arr[i][1], arr, cnt+1);
				visit[i] = false;
			}
		}
	}
}
