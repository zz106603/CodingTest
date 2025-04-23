package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> amount = new ArrayList<>();
        for(int i=0; i<N; i++){
            amount.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(amount, Collections.reverseOrder());

        int idx = 0;
        int res = 0;
        while(K != 0){
            if(amount.get(idx) <= K){
                res += K/amount.get(idx);
                K = K%amount.get(idx);
            }
            idx++;
        }

        System.out.println(res);

    }
}
