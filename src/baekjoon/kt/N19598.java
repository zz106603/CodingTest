package baekjoon.kt;

import java.io.*;
import java.util.*;

public class N19598 {
    static class Room {
        int start;
        int end;
        boolean used;
        Room(int start, int end, boolean used){this.start=start; this.end=end; this.used=used;}
    }

    static boolean check(Room[] rooms){
        for(Room r : rooms){
            if(!r.used) return false;
        }
        return true;
    }
    
    /*
        한 번 더 풀어보자
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Room[] room = new Room[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            room[i] = new Room(a, b, false);
        }

        Arrays.sort(room, (a, b) -> {
            if(a.end == b.end) return a.start - b.start;
            return a.end - b.end;
        });

        /*
        5 10
        15 30
        0 40
         */

            int total = 0;
            int idx = 0;
            for(int j=0; j<N; j++){
                if(check(room)) break;
                if(room[j].used) continue;

                idx++;
//                System.out.println(idx + "번 돔");

                int count = 1;
                int finish = room[j].end;
                room[j].used = true;
                for(int k=j+1; k<N; k++){
                    if(finish <= room[k].start && !room[k].used){
                        room[k].used = true;
                        count++;
                        finish = room[k].end;
                    }
                }
                total += count;
//                System.out.println((z-1) + "번 돔: " + total);
                if(total == N) break;
            }

            System.out.println(idx);

            /*

            1	10
            2	3
            3	4

             */

    }
}
