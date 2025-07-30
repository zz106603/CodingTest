package baekjoon.random;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /*
            100 C 6
            100개 중에 6개를 뽑을 조합
         */

        BigInteger ans = nCm(n, m);

        System.out.println(ans);

    }

    public static BigInteger nCm(int n, int m){
        // nCm = n * (n-1) * (n-2) * ... * (n-m+1) / (1 * 2 * 3 * ... * m)
        BigInteger res = BigInteger.ONE;

        for(int i=0; i<m; i++){
            res = res.multiply(BigInteger.valueOf(n - i));
            res = res.divide(BigInteger.valueOf(i + 1));
        }
        return res;
    }
}
