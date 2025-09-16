package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];

        for(int i=0; i<N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        double bestEnding = arr[0];
        double ans = arr[0];

        for(int i=1; i<N; i++){
            // 현재가 더 큰지, 이전 값*현재가 더 큰지
            bestEnding = Math.max(arr[i], bestEnding*arr[i]);
            ans = Math.max(ans, bestEnding);
        }

        System.out.printf("%.3f", ans);
    }
}
