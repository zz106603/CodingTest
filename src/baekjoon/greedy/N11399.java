package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11399 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] time = new int[N];
        for(int i=0; i<N; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        /*
        1 2 3 4 5
        3 1 4 3 2

        1, 3, 6, 9, 13

        1 2 3 3 4
         */
        Arrays.sort(time);

        int sum = 0;
        int res = 0;
        for(int i=0; i<N; i++){
            sum += time[i];
            res += sum;
        }

        System.out.println(res);

    }
}
