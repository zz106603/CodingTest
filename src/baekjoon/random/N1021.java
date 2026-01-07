package baekjoon.random;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*
        10 3
        2 9 5

        이 문제의 포인트는 deque에서 찾고자 하는 값의 index 위치를 알아내는 것
        -> deque size의 중간보다 작으면 뒤로 옮기는게 최소 count
        -> deque size의 중간보다 크거나 같으면 앞으로 옮기는게 최소 count
         */

        LinkedList<Integer> dq = new LinkedList<>();
        for(int i=1; i<=N; i++){
            dq.addLast(i);
        }

        int res = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;

            while(!dq.isEmpty()){
                if(num == dq.peekFirst()){
                    res += cnt;
                    dq.pollFirst();
                    break;
                }else{
                    int target = dq.indexOf(num);
                    if(dq.size()/2 < target){
                        dq.addFirst(dq.pollLast());
                    }else{
                        dq.addLast(dq.pollFirst());
                    }
                    cnt++;
                }
            }
        }
        System.out.println(res);
    }
}
