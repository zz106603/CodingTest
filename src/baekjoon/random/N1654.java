package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        for(int i=0; i<K; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        // 문제 조건이 2 <= 가 아니기 때문에 1부터 시작해야 /2를 했을 때 0이 나오지 않음
        long left = 1;
        long right = arr[K-1];
        long count = 0;
        long answer = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            for(long num : arr){
                count += num/mid;
            }

            if(count >= N){
                // 정렬된 배열이라 수렴할 때 마다 최댓값이므로 Math.max를 사용하지 않아도 됨
                answer = mid;
                left = mid + 1;
            }else if(count < N){
                right = mid - 1;
            }
            count = 0;
        }

        System.out.println(answer);

    }
}
