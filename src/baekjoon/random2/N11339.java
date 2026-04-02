package baekjoon.random2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int cur = 0;
        for(int i=1; i<N+1; i++){
            cur += arr[i];
            answer += cur;
        }

        System.out.println(answer);
    }
}
