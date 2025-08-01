package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        /*
            소인수분해
            어떤 N의 소인수는 무조건 하나 이상이 √N보다 작거나 같다.
            따라서 Math.sqrt()로 할 수 있지만 함수 호출이라 더 빠른 방법인 i*i로 해결
         */
        for(int i=2; i*i<=N; i++){
            while(N % i == 0){
                System.out.println(i);
                N /= i;
            }
        }

        if(N > 1){
            System.out.println(N);
        }

    }
}
