package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N1922 {
    static class Edge{
        int from;
        int to;
        int cost;
        Edge(int from, int to, int cost){this.from = from; this.to = to; this.cost = cost;}
    }

    static List<Edge> edges = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());;
            int c = Integer.parseInt(st.nextToken());;
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges, (a, b) -> {
            return a.cost - b.cost;
        });

        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        int total = 0;
        for(Edge e : edges){
            if(find(e.from) != find(e.to)){
                union(e.from, e.to);
                total += e.cost;
            }
        }

        System.out.println(total);
        
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}
