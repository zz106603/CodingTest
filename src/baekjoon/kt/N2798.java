package baekjoon.kt;

import java.io.*;
import java.util.StringTokenizer;

public class N2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                int sum1 = arr[i] + arr[j];
                for(int z=j+1; z<N; z++){
                    int sum2 = sum1 + arr[z];
                    if(sum2 <= M){
                        max = Math.max(max, sum2);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
