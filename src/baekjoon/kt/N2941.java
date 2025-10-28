package baekjoon.kt;

import java.io.*;
import java.util.StringTokenizer;

public class N2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rules = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String input = br.readLine();
        for(int i=0; i<rules.length; i++){
            if(input.contains(rules[i])){
                input = input.replaceAll(rules[i], "T");
            }
        }
        System.out.println(input.length());
    }
}
