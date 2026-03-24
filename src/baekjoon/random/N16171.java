package baekjoon.random;

import java.io.*;
import java.util.*;

public class N16171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            char 자료형에서 문자열이 아닌 숫자(유니코드 포함)을 찾기 위해선
            Character.isDigit를 사용해 판단하면 됨
         */
        String s = br.readLine();
        String k = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                sb.append(c);
            }
        }

        System.out.println(sb.toString().contains(k) ? 1 : 0);

    }
}
