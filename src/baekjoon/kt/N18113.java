package baekjoon.kt;

import java.io.*;
import java.util.*;

public class N18113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int lastSize = K*2;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num < lastSize) {
                if(num > K){
                    list.add(num - K);
                }
            }else{
                list.add(num - lastSize);
            }
        }

        if(list.isEmpty()) {
            System.out.println(-1);
            return;
        }

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);

        int ans = -1;
        int left = 1;
        int right = arr[arr.length-1];
        while(left <= right){
            int mid = (left + right) / 2;

            int sum = 0;
            for(int n : arr){
                sum += n/mid;
                if(sum >= M) break;
            }

            if(sum < M){
                right = mid - 1;
            }else{
                ans = Math.max(ans, mid);
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
