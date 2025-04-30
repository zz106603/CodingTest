package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*

        예를 들어 N=4인 경우를 생각해 보자.
        카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다.
        여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다.
        마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.

        1 2 3 4
        3 4 2
        2 4
        4
         */

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> qu = new LinkedList<>();

        for(int i=1; i<=N; i++){
            qu.add(i);
        }

        while(qu.size() != 1){
            qu.poll();
            qu.add(qu.poll());
        }

        System.out.println(qu.peek());
    }
}
