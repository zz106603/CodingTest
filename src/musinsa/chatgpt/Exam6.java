package musinsa.chatgpt;

import java.io.*;

public class Exam6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            연속으로 같은 문자가 반복되는 구간을 (문자)(반복횟수) 형태로 압축해서 출력
            - 반복 횟수가 1이면 숫자는 출력하지 않음
            - 출력은 구간 순서대로 이어 붙임
         */

        char[] c = br.readLine().toCharArray();

        char cur = c[0];
        int cnt = 1;
        for(int i=1; i<c.length; i++){
            if(cur == c[i]){
                cnt++;
            }else{
                if(cnt > 1) bw.write(cur+""+cnt);
                else bw.write(cur);
                cnt = 1;
                cur = c[i];
            }
        }

        if(cnt > 1) bw.write(cur+""+cnt);
        else bw.write(cur);

        bw.flush();
        bw.close();
    }
}
