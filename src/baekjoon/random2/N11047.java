package baekjoon.random2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[N];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (a, b) -> {
           return Integer.compare(b, a);
        });

        int answer = 0;
        int idx = 0;
        while(K != 0){
            if(K >= arr[idx]){
                answer += K/arr[idx];
                K = K%arr[idx];
            }else{
                idx++;
            }
        }

        System.out.println(answer);
    }
}
