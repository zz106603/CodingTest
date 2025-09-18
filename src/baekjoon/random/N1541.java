package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N1541 {
    static int sum(String str){
        int res = 0;
        String[] strArr = str.split("\\+");
        for(String s : strArr){
            res += Integer.parseInt(s);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 10+20+30-40+50-60+70
        String[] parts = br.readLine().split("-");

        int first = sum(parts[0]);
        int second = 0;
        for(int i=1; i<parts.length; i++){
            second += sum(parts[i]);
        }

        System.out.println(first - second);
    }
}
