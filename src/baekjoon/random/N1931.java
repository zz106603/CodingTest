package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1931 {
    static class Time {
        int start;
        int end;
        Time(int start, int end) { this.start = start; this.end = end; }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Time[] timeArr = new Time[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            timeArr[i] = new Time(s, e);
        }

        Arrays.sort(timeArr, (a, b) -> {
            if (a.end == b.end) return Integer.compare(a.start, b.start);
            return Integer.compare(a.end, b.end);
        });

        int count = 0;
        int end = 0;
        for(int i=0; i<timeArr.length; i++){
            if(end <= timeArr[i].start){
                count++;
                end = timeArr[i].end;
            }
        }
        System.out.println(count);


//        int answer = 1;
//        int e = timeArr[0].end;
//        for(int i=1; i<timeArr.length; i++) {
//            int ns = timeArr[i].start;
//            int ne = timeArr[i].end;
//            if (e <= ns) {
//                answer++;
//                e = ne;
//            }
//        }
//        System.out.println(answer);

    }
}
