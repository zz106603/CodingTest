package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N1647 {

    static class Edge{
        int from;
        int to;
        int cost;
        Edge(int from, int to, int cost){this.from = from; this.to = to; this.cost = cost;}
    }

    static int N, M;
    static int[] parent;
    static List<Edge> edges = new ArrayList<>();

    /*
        Kruskal 알고리즘
        - 비용이 낮은 도로부터 차례로 하나씩 연결하면서 사이클이 생기지 않도록 집들을 묶음
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        // 간선 가중치 기준 정렬
        Collections.sort(edges, (a, b) -> {
            return a.cost - b.cost;
        });

        // Union-Find 초기화
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        int total = 0; // MST 총 비용
        int maxEdge = 0; // MST에서 가장 큰 간선 비용

        for(Edge e : edges){
            if(find(e.from) != find(e.to)){ // 사이클이 없으면 연결
                union(e.from, e.to);
                total += e.cost;
                maxEdge = Math.max(maxEdge, e.cost); // 가장 큰 간선
            }
        }

        System.out.println(total - maxEdge);


    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}
