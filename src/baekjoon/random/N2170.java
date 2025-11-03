package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N2170 {
    static class Ruler{
        long start;
        long end;
        Ruler(long start, long end){this.start = start; this.end = end;}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        4
        1 3 = 2
        2 5 = 2
        3 5 = 0
        6 7 = 1

        1 6 = 5
        2 5 = 0
        3 5 = 0
        6 7 = 1

        -10 -2 = 8
        -3  7 = 10

        -1 -1 = 0

        -3 0

        1 5 -> 4
        1 3 ->

        1 3 -> 2
        2 5 -> 2

        1000000000
         */

        long ans = 0;
        int N = Integer.parseInt(br.readLine());

        List<Ruler> list = new ArrayList<>();
        long curEnd = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            list.add(new Ruler(start, end));
        }

        Collections.sort(list, (a, b) -> {
            if(a.start == b.start) return Long.compare(b.end, a.end);
            return Long.compare(a.start, b.start);
        });

        for(int i=0; i<list.size(); i++){
            Ruler r = list.get(i);
//            System.out.println(r.start + " " + r.end);
            if(i == 0){
                ans = r.end - r.start;
                curEnd = r.end;
                continue;
            }
            // 1 3
            // 5 6
            if(r.start < curEnd){
                if(r.end > curEnd){
                    ans += r.end - curEnd;
                }
            }else{
                ans += r.end - r.start;
            }
            curEnd = Math.max(curEnd, r.end);
//            System.out.println(ans);

        }

        System.out.println(ans);
    }
}
