package baekjoon.random2;

import java.io.*;
import java.util.StringTokenizer;

public class N1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        /*
            알파벳 관련은 26개의 배열을 만들고
            charAt(i) - 'a'로 인덱스를 구하는 방식으로 하자
         */

        int answer = 0;
        for(int i=0; i<N; i++){
            String s = br.readLine();
            boolean flag = true;

            int[] arr = new int[26];
            char cur = '0';
            for(int j=0; j<s.length(); j++){
                int idx = s.charAt(j) - 'a';

                if(s.charAt(j) != cur && arr[idx] == 1){
                    flag = false;
                    break;
                }else{
                    arr[idx] = 1;
                    cur = s.charAt(j);
                }
            }

            if(flag) answer++;
        }

        System.out.println(answer);
    }
}
