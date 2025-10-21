package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1, 1, 1, 2, 2, 3, 4, 5, 7, 9

        int T = Integer.parseInt(br.readLine());

        for(int k=0; k<T; k++){
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];

            if(n == 1 || n == 2 || n == 3){
                bw.write(1+"\n");
                continue;
            }

            arr[0] = 1;
            arr[1] = 1;
            arr[2] = 1;

            for(int i=3; i<n; i++){
                arr[i] = arr[i-2] + arr[i-3];
            }

            bw.write(arr[n-1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
