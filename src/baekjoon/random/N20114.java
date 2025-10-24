package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N20114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        String[] res = new String[N*W];
        Arrays.fill(res, "?");

        for(int i=0; i<H; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<input.length; j++){
                if(!input[j].equals("?")){
                    res[j] = input[j];
                }
            }
        }

        for(int i=0; i<N*W; i+=W){
            boolean flag = false;
            for(int j=i; j<i+W; j++){
                if(!res[j].equals("?")){
                    bw.write(res[j]);
                    flag = true;
                    break;
                }
            }
            if(!flag) bw.write("?");
        }

        bw.flush();
        bw.close();
    }
}
