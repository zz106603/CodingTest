package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N14179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 3 1 2 3 4 1 1 2

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        leftMax[0] = height[0];
        for(int i=1; i<W; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[W-1] = height[W-1];
        for(int i=W-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int ans = 0;
        for(int i=0; i<W; i++){
            int res = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(res < 0) continue;
            ans += res;
        }

        System.out.println(ans);
    }
}
