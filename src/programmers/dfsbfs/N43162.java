package programmers.dfsbfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N43162 {
	
	static List<Integer>[] comList;
	static boolean[] visit;
	static int count = 0;

	public static void main(String[] args) throws IOException{
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

		comList = new ArrayList[n];
		visit = new boolean[n];

		for(int i=0; i<n; i++){
			comList[i] = new ArrayList<>();
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(i == j){
					continue;
				}else if(computers[i][j] == 1){
					comList[i].add(j);
					comList[j].add(i);
				}
			}
		}

		for(int i=0; i<n; i++){
			if(!visit[i]){
				count++;
				dfs(i);
			}
		}

		System.out.println(count);
	}

	public static void dfs(int v){
		visit[v] = true;

		for(int next : comList[v]){
			if(!visit[next]) dfs(next);
		}
	}
}
