package baekjoon.random;

import java.io.*;
import java.util.*;

public class N1966 {
    static class Print{
        int num;
        int idx;
        Print(int num, int idx){this.num = num; this.idx = idx;}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Print> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                q.add(new Print(num, j));
            }

            int cnt = 0;
            while(!q.isEmpty()){
                Print cur = q.poll();

                boolean higher = false;
                for(Print pr : q){
                    if(pr.num > cur.num){
                        higher = true;
                        break;
                    }
                }

                if(higher){
                    q.add(cur);
                }else{
                    // 인쇄됨
                    cnt++;
                    if(cur.idx == M){
                        bw.write(cnt + "\n");
                        break;
                    }
                }
            }
        }

        bw.flush();
        bw.close();


    }
}

/*
(9,2) (1,3) (1,4) (1,5) (1,0) (1,1)
 */
