package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            arr[i] = s;
        }

        for(int i=0; i<arr[0].length(); i++){
            char prev = arr[0].charAt(i);
            boolean flag = true;
            for(int j=0; j<N; j++){
                if(prev != arr[j].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag) bw.write(arr[0].charAt(i));
            else bw.write("?");
        }

        bw.flush();
        bw.close();

    }
}
