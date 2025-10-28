package baekjoon.kt;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase();

        int[] cnt = new int[26];
        for(char c : str.toCharArray()){
            cnt[c - 'A']++;
        }

        int max = 0;
        char res = '?';
        for(int i=0; i<26; i++){
            if(cnt[i] > max){
                max = cnt[i];
                res = (char)(i + 'A');
            }else if(cnt[i] == max){
                res = '?';
            }
        }

        System.out.println(res);
    }
}
