package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N11170 {

    static final int MAX = 1_000_000;
    static int[] prefix = new int[MAX+1];

    public static int countZero(int x){
        int cnt = 0;
        while(x > 0){
            if(x % 10 == 0) cnt++;
            x /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        /*
            누적합 방법
         */
        prefix[0] = 1;
        for(int i=1; i<=MAX; i++){
            prefix[i] = prefix[i-1] + countZero(i);
        }

        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int result = 0;
            if(N == 0) result = prefix[M];
            else result = prefix[M] - prefix[N-1];

            bw.write(result + "\n");
        }

        /*
            원초적인 반복문 방법
         */
//        for(int i=0; i<T; i++){
//            int count = 0;
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//
//            for(int j=N; j<=M; j++){
//                String s = String.valueOf(j);
//                for(int k=0; k<s.length(); k++){
//                    if(s.charAt(k) == '0') count++;
//                }
//            }
//
//            bw.write(count + "\n");
//        }

        bw.flush();
        bw.close();
    }
}
