package baekjoon.random2;

import java.io.*;
import java.util.*;

public class N1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];

        String s = br.readLine().toUpperCase();
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i) - 'A']++;
        }

        int max = 0;
        char res = '?';
        for(int i=0; i<26; i++){
            if(max < arr[i]){
                max = arr[i];
                res = (char)(i + 'A');
            }else if(max == arr[i]){
                res = '?';
            }
        }

        System.out.println(res);
    }
}
