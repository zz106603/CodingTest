package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            arr[i] = s;
        }

        Arrays.sort(arr, (a, b) -> {
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
           return a.length() - b.length();
        });

        String prev = "";
        for(String s : arr){
            if(prev.equals(s)) continue;
            sb.append(s).append("\n");
            prev = s;
        }

        System.out.print(sb.toString());
    }
}
