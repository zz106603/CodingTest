package baekjoon.random;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i=0; i<N; i++){
            Set<Character> set = new HashSet<>();

            String in = br.readLine();
            boolean check = true;
            char prev = ' ';
            for(int j=0; j<in.length(); j++){
                if(in.charAt(j) != prev){
                    if(set.contains(in.charAt(j))){
                        check = false;
                        break;
                    }
                    set.add(in.charAt(j));
                    prev = in.charAt(j);
                }
            }

            if(check) ans++;
        }

        System.out.println(ans);
    }
}
