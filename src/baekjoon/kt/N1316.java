package baekjoon.kt;

import java.io.*;
import java.util.StringTokenizer;

public class N1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int ans = 0;
        for(int i=0; i<T; i++){
            int[] alp = new int[26];
            char[] word = br.readLine().toCharArray();
            boolean flag = true;
            char prev = ' ';
            for(int j=0; j<word.length; j++){
                char c = word[j];
                if(prev == c) continue;

                if(alp[c - 'a'] == 0){
                    alp[c - 'a']++;
                    prev = c;
                }else{
                    flag = false;
                    break;
                }
            }

            if(flag) ans++;
        }

        System.out.println(ans);
    }
}
