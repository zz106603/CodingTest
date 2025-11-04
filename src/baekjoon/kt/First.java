package baekjoon.kt;

import java.io.*;
import java.util.StringTokenizer;

public class First {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[]{14, 4, 9, 10, 4};
        int maxVal = 0;
        for(int x : arr) maxVal = Math.max(x, maxVal);

        int[] count = new int[maxVal + 1];
        for(int x : arr){
            for(int i=1; i*i<=x; i++){
                if(x%i == 0){
                    count[i]++;
                    if(x/i != i){
                        count[x/i]++;
                    }
                }
            }
        }

        int ans = 0;
        for(int i=2; i<count.length; i++){
            ans = Math.max(ans, count[i]);
        }

        System.out.println(ans);


    }
}
