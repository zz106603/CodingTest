package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){ arr[i] = Long.parseLong(st.nextToken()); }
        Arrays.sort(arr);

        long[] ans = new long[2];

        int left = 0;
        int right = N-1;
        long min = Long.MAX_VALUE;
        while(left < right){
            // sum < 0, sum > 0에 따라서 left ,right를 움직여야 하기에 여기에 절대값 금지
            long sum = arr[left] + arr[right];
            long abs = Math.abs(sum);
            if(min > abs){
                min = abs;
                ans[0] = arr[left];
                ans[1] = arr[right];
            }

            if(sum < 0){
                left++;
            }else{
                right--;
            }
        }

        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1]);

    }
}
