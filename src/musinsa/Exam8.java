package musinsa;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            N개의 스위치 배열. 각 칸은 0, 1
            작업이 Q개 주어짐

            T i : i번째 스위치를 뒤집음(0 <-> 1)
            C l r : 구간 [l, r]에서 1의 개수를 출력
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        String[] s = br.readLine().split("");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int l, r, idx;
            int cnt = 0;
            if(type.equals("C")){
                l = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());
                for(int j=l-1; j<r; j++){
                    if(arr[j] == 1) cnt++;
                }
                bw.write(cnt + "\n");
            }else{
                idx = Integer.parseInt(st.nextToken());
                if(arr[idx-1] == 0) arr[idx-1] = 1;
                else arr[idx-1] = 0;
            }
        }

        bw.flush();
        bw.close();

    }
}
