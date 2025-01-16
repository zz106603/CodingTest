package programmers.heap;

import java.util.PriorityQueue;

public class N42626 {

    public static void main(String[] args){

    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> qu = new PriorityQueue<>();

        for(int val : scoville){
            qu.add(val);
        }

        boolean flag = false;
        while(qu.peek() < K){
            if(qu.size() == 1) break;

            int first = qu.poll();
            int second = qu.poll();
            int newSco = first + (second*2);
            qu.add(newSco);

            answer++;
        }

        if(qu.peek() >= K){
            return answer;
        }else{
            return -1;
        }
    }
}
