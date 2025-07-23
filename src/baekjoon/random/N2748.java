package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

//        long[] arr = new long[n+1];
//        arr[0] = 0;
//        if(n > 0) arr[1] = 1;
//
//        for(int i=2; i<=n; i++){
//            arr[i] = arr[i-1] + arr[i-2];
//        }
//
//        System.out.println(arr[n]);

        /*
            위 방법은 arr에 전부 저장하기 때문에 공간 복잡도 측면에서 아래와 같은 풀이도 가능
         */

        if(n == 0 || n == 1){
            System.out.println(n);
            return;
        }

        long prev = 0; long curr = 1;
        long res = 0;
        for(int i=2; i<=n; i++){
            res = prev + curr;
            prev = curr;
            curr = res;
        }

        System.out.println(res);
    }
}
