package baekjoon.kt;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for(int[] a : arr){
            System.out.println(a[0] + " " + a[1]);
        }
    }
}
