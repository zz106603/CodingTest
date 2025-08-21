package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 K의 합이 maxSum의 초기값
        int windowSum = 0;
        for(int i=0; i<K; i++) windowSum += arr[i];
        int maxSum = windowSum;

        /*
            K가 3이라면 0, 1, 2로 합계가 저장되어 있음
            그러면 다음 합은 arr[3]을 더하고 arr[0]을 제외하면 됨
         */
        for(int i=K; i<N; i++){
            windowSum += arr[i] - arr[i-K];
            maxSum = Math.max(windowSum, maxSum);
        }

        System.out.println(maxSum);
    }

}
