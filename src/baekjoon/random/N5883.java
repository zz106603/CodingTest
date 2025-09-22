package baekjoon.random;

import java.io.*;
import java.util.*;

public class N5883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            set.add(num);
        }

        /*
        2, 7, 3, 7, 7, 3, 7, 5, 7
         */

        int max = 1;
        for (int check : set) {
            int cur = arr[0];
            int count = 1;
            for(int i=1; i<N; i++){
                if(arr[i] == check) continue;

                if(arr[i] != cur){
                    cur = arr[i];
                    count = 1;
                }else{
                    count++;
                    max = Math.max(max, count);
                }
            }
        }

        System.out.println(max);

    }
}
