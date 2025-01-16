package programmers.heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class N42627 {

    public static void main(String[] args){

    }

    public int solution(int[][] jobs) {

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        Queue<int[]> qu = new LinkedList<>();
        for(int[] job: jobs){
            qu.add(job);
        }

        PriorityQueue<int[]> waitQ = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int curTime = 0; // 현재 시간
        int total = 0; // 걸린 시간
        int count = 0; // 처리 개수

        while(count < jobs.length){

            // 현재 시간까지 도착한 작업을 waitQ에 추가
            while(!qu.isEmpty() && qu.peek()[0] <= curTime){
                waitQ.add(qu.poll());
            }

            // 현재 시간(curTime)까지 도착한 작업이 없으면, 현재 시간(curTime)을 다음 작업 시작 시간으로 지정
            if(waitQ.isEmpty()){
                curTime = qu.peek()[0];
            }else{
                int[] cur = waitQ.poll();
                total += cur[1] + curTime - cur[0];
                curTime += cur[1];
                count++;
            }
        }

        return total/jobs.length;
    }
}
