package baekjoon.random;

import java.io.*;
import java.util.*;

public class N1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        long answer = 0;
        for(int i=0; i<N; i++){
            int res = arr[i] - i;
            if(res < 0) continue;

            answer += res;
        }

        System.out.println(answer);
    }
}
