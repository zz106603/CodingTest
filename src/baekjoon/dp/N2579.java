package baekjoon.dp;

import java.io.*;

public class N2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] score = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1){
            System.out.println(arr[1]);
            return;
        }

        score[1] = arr[1];
        score[2] = arr[1] + arr[2];

        for(int i=3; i<=n; i++){
            score[i] = Math.max(arr[i-1] + score[i-3], score[i-2]) + arr[i];
        }

        System.out.println(score[n]);
    }
}
