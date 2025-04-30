package baekjoon.deque;

import java.io.*;
import java.util.*;

public class N5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        4
        RDD
        4
        [1,2,3,4]
        DD
        1
        [42]
        RRD
        6
        [1,1,2,3,5,8]
        D
        0
        []

            중요한 포인트!
            1. R일 경우 실제 reverse를 진행하는 것이 아니라 논리적으로 진행 (boolean)
            2. 논리적으로 reverse 적용할 경우 앞, 뒤 삭제가 필요 -> deque 사용
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());

        for(int k=0; k<total; k++) {
            String[] fun = br.readLine().split("");

            int N = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();

            String str = br.readLine();
            if(N > 0){
                String subStr = str.substring(1, str.length()-1);
                String[] arrStr = subStr.split(",");
                for (int i = 0; i < N; i++) {
                    deque.offerLast(Integer.parseInt(arrStr[i]));
                }
            }
            boolean isReverse = false;
            boolean flag = true;
            for (String s : fun) {
                if (s.equals("R")) {
                    isReverse = !isReverse;
                } else {
                    if(deque.isEmpty()){
                        flag = false;
                        break;
                    }
                    if(isReverse){
                        deque.pollLast();
                    }else{
                        deque.pollFirst();
                    }
                }
            }

            if (flag) {
                bw.write("[");
                StringBuilder sb = new StringBuilder();
                if(isReverse){
                    Iterator<Integer> it = deque.descendingIterator(); // Deque를 역순으로 출력
                    while(it.hasNext()){
                        sb.append(it.next()).append(",");
                    }
                }else{
                    for (Integer integer : deque) {
                        sb.append(integer).append(",");
                    }
                }
                if(sb.length() > 0) {
                    sb.setLength(sb.length()-1);
                }
                bw.write(sb.toString());
                bw.write("]\n");
            } else {
                bw.write("error\n");
            }
        }

        bw.flush();
        bw.close();
    }

}
