package baekjoon.random;

import java.io.*;

public class N4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while((line = br.readLine()) != null){
            int N = Integer.parseInt(line);
            int length = (int)Math.pow(3, N);
            char[] arr = new char[length];
            for(int i=0; i<length; i++) arr[i] = '-';

            dfs(arr, 0, length);

            System.out.println(new String(arr));
        }
    }

    static void dfs(char[] arr, int start, int size){
        if(size == 1) return;
        int third = size/3;

        for(int i=start + third; i<start + 2 * third; i++){
            arr[i] = ' ';
        }

        dfs(arr, start, third);
        dfs(arr, start + 2 * third, third);

    }
}

