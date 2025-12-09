package baekjoon.random;

import java.io.*;
import java.util.*;

public class N15649V2 {

    static boolean[] visit;
    static int N, M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        dfs(new ArrayList<>());

        bw.flush();
        bw.close();
    }

    public static void dfs(List<Integer> res) throws IOException{
        if(res.size() == M){
            for(int r : res){
                bw.write(r + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visit[i]){
                res.add(i);
                visit[i] = true;
                dfs(res);
                res.remove(res.size()-1);
                visit[i] = false;
            }
        }
    }
}
