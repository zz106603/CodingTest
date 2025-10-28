package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N17393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        long[] B = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) B[i] = Long.parseLong(st.nextToken());

        /*
        6
        60 90 100 88 90 99
        60 70 80 85 90 90
         */

        for(int i=0; i<N; i++){
            int res = 0;

            int left = i+1;
            int right = N;
            /*
                left는 닫혀있고, right는 열려있음
                이는 [left, right)로 표현이 가능
                left < right로 반복하면서 right = mid-1이 아닌, right = mid
             */
            while(left < right){
                int mid = (left + right) / 2;

                if(B[mid] <= A[i]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }

            res = left - (i+1);
            bw.write(res + " ");
        }

        bw.flush();
        bw.close();

    }
}
