package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int ans = 0;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            long sum = 0L;
            for(int i=0; i<N; i++){
                if(arr[i] > mid){
                    sum += arr[i] - mid;
                }
            }

            // 이미 mid가 가능하다는 것은 이전 것들은 다 가능 (최대값을 찾는 것이므로 이전 것들 검증 필요X)
            if(sum >= M){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
