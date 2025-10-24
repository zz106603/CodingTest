package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N15649 {
    static int N, K;
    static int[] arr;
    static List<List<Integer>> result = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        visit = new boolean[N+1];
        for(int i=1; i<=N; i++) arr[i] = i;

        dfs(arr, new ArrayList<>());

        for(List<Integer> l : result){
            for(int n : l){
                bw.write(n + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int[] arr, List<Integer> res){
        if(K == res.size()){
            result.add(new ArrayList<>(res));
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visit[i]){
                visit[i] = true;
                res.add(arr[i]);
                dfs(arr, res);
                res.remove(res.size()-1);
                visit[i] = false;
            }
        }
    }
}
