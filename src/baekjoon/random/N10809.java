package baekjoon.random;

import java.io.*;
import java.util.*;

public class N10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];

        for(int i=0; i<26; i++){
            arr[i] = -1;
        }

        String s = br.readLine();

        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';

            if(arr[idx] == -1){
                arr[idx] = i;
            }
        }

        for(int i=0; i<26; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
