package baekjoon.random;

import java.io.*;
import java.util.*;

public class N2422 {

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                if(arr[i][j]) continue;
                for(int k=j+1; k<=N; k++){
                    if(arr[i][k] || arr[j][k]) continue;
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
