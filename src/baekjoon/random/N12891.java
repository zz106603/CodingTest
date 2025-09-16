package baekjoon.random;

import java.io.*;
import java.util.*;

public class N12891 {
    static int idx(char ch){
        switch (ch) {
            case 'A' : return 0;
            case 'C' : return 1;
            case 'G' : return 2;
            default : return 3;
        }
    }

    static boolean ok(int[] have, int[] need){
        for(int i=0; i<4; i++){
            if(have[i] < need[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] s = br.readLine().toCharArray();

        /*
            이 문제의 포인트는 특정 P 범위의 특정 문자열을 가지고 조건 검사를 하는 것이므로, 슬라이딩 윈도우 알고리즘
            A, C, G, T를 배열로 표현하기 위해 swith문을 사용하여 인덱스(idx)를 지정

            현재 개수 have, 기준 개수 need를 사용
            [i-P]의 값은 -1, [i]값은 +1
            반복하면서 비밀번호로 가능한지 검사
         */
        int[] have = new int[4];
        int[] need = new int[4];

        st = new StringTokenizer(br.readLine());
        need[0] = Integer.parseInt(st.nextToken());
        need[1] = Integer.parseInt(st.nextToken());
        need[2] = Integer.parseInt(st.nextToken());
        need[3] = Integer.parseInt(st.nextToken());

        for(int i=0; i<P; i++){
            have[idx(s[i])]++;
        }

        int answer = 0;
        if(ok(have, need)) answer++;

        for(int i=P; i<S; i++){
            have[idx(s[i-P])]--;
            have[idx(s[i])]++;

            if(ok(have, need)) answer++;
        }

        System.out.println(answer);
    }
}
