package baekjoon.random;

import java.io.*;
import java.util.*;

public class N15666 {

    static int[] arr;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(new LinkedList<>(), 0, 0);
    }

    public static void dfs(LinkedList<Integer> res, int prev, int start){
        if(res.size() == K){
            for(int r : res){
                System.out.print(r + " ");
            }
            System.out.println();
            return;
        }

        int last = Integer.MAX_VALUE;
        for(int i=start; i<arr.length; i++){
            if(arr[i] == last) continue;
            last = arr[i];

            res.add(arr[i]);
            dfs(res, prev, i);
            res.removeLast();
        }
    }
}
