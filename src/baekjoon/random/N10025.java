package baekjoon.random;

import java.io.*;
import java.util.*;

public class N10025 {
    static class Bucket{
        int x;
        int g;
        Bucket(int x, int g){
            this.x = x; this.g = g;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
            우리 안은 1차원 배열로 생각하며, 총 N(1 ≤ N ≤ 100000)개의 얼음 양동이들이 xi(0 ≤ xi ≤ 1,000,000)좌표마다 놓여 있고
            각 양동이 안에는 gi(1 ≤ gi ≤ 10,000)씩의 얼음이 들어 있다.
            일단 앨버트가 자리를 잡으면 그로부터 좌우로 K(1 ≤ K ≤ 2,000,000) 만큼 떨어진 양동이까지 닿을 수 있다.
            앨버트는 양동이가 놓여 있는 자리에도 자리잡을 수 있다. 모든 얼음 양동이의 위치는 다르다.
         */

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Bucket[] arr = new Bucket[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[i] = new Bucket(x, g);
        }

        Arrays.sort(arr, (b1, b2) -> {
            return b1.x - b2.x;
        });

        long ans = 0;
        long sum = 0;
        int left = 0;
        for(int right=0; right<N; right++){
            sum += arr[right].g;
            while(arr[right].x - arr[left].x > 2L * K){
                sum -= arr[left].g;
                left++;
            }
            ans = Math.max(ans, sum);
        }

       System.out.println(ans);
    }
}
