package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N14697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
        방의 종류가 5인실, 9인실, 12인실이고 6학년 여학생 전체가 113명
        5인실 4개, 9인실 5개, 12인실 4개를 예약하면 각 방에 남는 침대 없이 배정이 가능
        12인실은 사용하지 않고 5인실 10개와 9인실 7개만 사용하는 것도 가능

        3인실, 6인실, 9인실이고 6학년 여학생 전체가 112명이라면 빈 침대 없이 방을 배정하는 것은 불가능
         */

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        if(a == 1) {
            System.out.println(1);
            return;
        }

        for(int i=0; i<=N/a; i++){
            for(int j=0; j<=N/b; j++){
                for(int k=0; k<=N/c; k++){
                    if(a*i + b*j + c*k == N){
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}
