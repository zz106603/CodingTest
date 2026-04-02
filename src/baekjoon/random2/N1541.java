package baekjoon.random2;

import java.io.*;
import java.util.StringTokenizer;

public class N1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        String[] arr = input.split("-");

        for(int i=0; i<arr.length; i++){
            if(arr[i].contains("+")){
                String[] val = arr[i].split("\\+");
                int sum = 0;
                for(int j=0; j<val.length; j++){
                    sum += Integer.parseInt(val[j]);
                }
                arr[i] = String.valueOf(sum);
            }
        }

        int answer = Integer.parseInt(arr[0]);
        for(int i=1; i<arr.length; i++){
            answer -= Integer.parseInt(arr[i]);
        }

        System.out.println(answer);
    }
}
