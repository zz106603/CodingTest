package baekjoon.kt;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N1182 {
    static int ans = 0;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(M == 0) ans--;

        System.out.println(ans);
    }


    public static void dfs(int start, int sum){
        if(start == N){
            if(sum == M){
                ans++;
            }
            return;
        }

        dfs(start+1, sum+arr[start]);
        dfs(start+1, sum);
    }
}
