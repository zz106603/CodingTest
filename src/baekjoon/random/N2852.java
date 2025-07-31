package baekjoon.random;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        /*
            3
            1 01:10
            2 21:10
            2 31:30

            20:00
            16:30

            이 문제는 현재 시간 기준으로 누가 이기고 있는지 판단
            1. 01:10에는 첫 득점으로 이제부터 시간을 측정해야 함 scoreA++
            2. 다음 B팀 득점이 나왔을때 A팀이 이기고 있었으니까 그 시간을 누적 timeA += cur - prev
            3. 현재는 동점 상황
            4. 다음 B팀 득점이 나왔으니까 이제부터 시간 측정 scoreB++
            5. for문이 끝나고 계산할 게 남아있으니까 48분에서 -값으로 시간 누적
         */

        int scoreA = 0, scoreB = 0;
        int timeA = 0, timeB = 0;
        int prevSec = toSec("00:00");

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            int curSec = toSec(st.nextToken());

            if(scoreA > scoreB){
                timeA += curSec - prevSec;
            }else if(scoreA < scoreB){
                timeB += curSec - prevSec;
            }

            if(team == 1) scoreA++;
            else scoreB++;

            prevSec = curSec;
        }
        int end = toSec("48:00");
        if(scoreA > scoreB) timeA += end - prevSec;
        else if(scoreB > scoreA) timeB += end - prevSec;

        System.out.println(String.format("%02d:%02d", timeA/60, timeA%60));
        System.out.println(String.format("%02d:%02d", timeB/60, timeB%60));
    }

    public static int toSec(String s){
        return Integer.parseInt(s.split(":")[0])*60 + Integer.parseInt(s.split(":")[1]);
    }
}
