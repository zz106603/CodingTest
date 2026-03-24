package baekjoon.random2;

import java.io.*;
import java.util.StringTokenizer;

public class N2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rule = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};

        String s = br.readLine();

        for(int i=0; i<rule.length; i++){
            s = s.replaceAll(rule[i], "0");
        }

        System.out.println(s.length());

    }
}
