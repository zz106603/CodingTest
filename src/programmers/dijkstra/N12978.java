package programmers.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class N12978 {

	
	/*
	 * https://school.programmers.co.kr/learn/courses/30/lessons/12978?language=java
	 * 음식 배달
	 */
	
	static List<Node>[] list;
	static int[] dp;
	static boolean[] visit;
	
	public static void main(String[] args) {
		int answer = 0;
		
		int N = 5;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int K = 3;
		//정답은 4
		
		list = new ArrayList[N+1];
		dp = new int[N+1];
		visit = new boolean[N+1];
		
		//List 초기화
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		//양방향 연결
		for(int i=0; i<road.length; i++) {
			int a = road[i][0];
			int b = road[i][1];
			int c = road[i][2];
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		dijkstra(1);
		
		for(int num : dp) {
			if(num <= K) {
				answer++;
			}
		}
		System.out.println(answer);

	}
	
	public static void dijkstra(int start) {
		//가중치가 낮은 순서대로
		Queue<Node> q = new PriorityQueue<>();
		//아직 지나가지 않은 값들 최대값 세팅
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		//queue 및 dp 시작값 세팅
		q.add(new Node(start, 0));
		dp[start] = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int to = node.to;
			
			if(visit[to]) continue;
			else visit[to] = true;
			
			/*
			 * 연결된 to를 가져와서 비교
			 * 다음으로 연결될 숫자의 총 가중치 값 >= 현재 연결 총 가중치 + 다음 연결 가중치
			 */
			for(Node nxt : list[to]) {
				if(dp[nxt.to] >= dp[to] + nxt.weight) {
					dp[nxt.to] = dp[to] + nxt.weight;
					q.add(new Node(nxt.to, dp[nxt.to]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int to;
	int weight;
	
	Node(int to, int weight){
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node n) {
		return Integer.compare(this.weight, n.weight);
	}
}
