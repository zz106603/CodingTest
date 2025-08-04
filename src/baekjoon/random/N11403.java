package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N11403 {
    static boolean[] visit;
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                if(num == 1){
                    arr[i][j] = 1;
                }
            }
        }

        /*
            플로이드-워셜 알고리즘
            모든 정점 쌍 (i, j)에 대해 최단 거리 또는 경로 존재 여부를 구하는 알고리즘

            쉽게 말해서 i -> k(중간 노드) -> j를 통해서 경로에 갈 수 있는지 판단
         */
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1){
                        arr[i][j] = 1;
                    }
                }
            }
        }

//        for(int i=0; i<N; i++){
//            visit = new boolean[N];
//            dfs(i, i);
//        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int start, int current){
        for(int next=0; next<N; next++){
            if(!visit[next] && arr[current][next] == 1){
                arr[start][next] = 1;
                visit[next] = true;
                dfs(start, next);
            }
        }
    }
}
