package programmers.random;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N17678 {
    public static void main(String[] args) throws IOException {
        int n = 2;
        int t = 10;
        int m = 2;
        String[] timetable = {"09:10", "09:09", "08:00"};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable){
            pq.offer(convertM(time));
        }

        /*
            1. 셔틀마다 태울 수 있는 사람들은 일단 다 태운다.
            2. 태우면서 마지막에 탄 사람은 기억해둔다(콘이 못 탈 경우에는 이 사람보다 1분 더 빨리 타야함)
            3. 마지막 셔틀이 왔을때 앞에 온 사람들을 모두 태운다.
                3-1. 다 태웠는데 자리가 남았으면 셔틀 출발시간에 타면 가장 늦게 도착
                3-2. 다 태웠는데 자리가 없으면 마지막 사람보다 1분 더 빨리 타야 가장 늦게 도착
         */

        int startTime = convertM("09:00");
        for(int i=0; i<n; i++){
            int seat = m;
            int lastTime = 0;
            while(!pq.isEmpty()){
                if(pq.peek() <= startTime && seat > 0){
                    lastTime = pq.poll();
                    seat--;
                }else{
                    break;
                }
            }
            if(i == n-1){
                if(seat > 0) System.out.println(convertH(startTime));
                else System.out.println(convertH(lastTime-1));
            }

            startTime += t;
        }
    }

    public static int convertM(String s){
        String[] time = s.split(":");
        int h = Integer.parseInt(time[0])*60;
        int m = Integer.parseInt(time[1]);
        return h + m;
    }

    public static String convertH(int time){
        int h = time/60;
        int m = time%60;
        return String.format("%02d:%02d", h, m);
    }
}
