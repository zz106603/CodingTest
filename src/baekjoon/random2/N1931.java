package baekjoon.random2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N1931 {
    public static class Room{
        Integer start;
        Integer end;
        public Room(Integer start, Integer end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Room> rooms = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Room room = new Room(a, b);
            rooms.add(room);
        }

        Collections.sort(rooms, (a, b) -> {
            if(a.end == b.end){
                return Integer.compare(a.start, b.start);
            }
            return Integer.compare(a.end, b.end);
        });

//        for(Room r : rooms){
//            System.out.println(r.start + " " + r.end);
//        }

        int curE = 0;
        int answer = 0;
        for(int i=0; i<N; i++){
            Room next = rooms.get(i);
            if(curE <= next.start){
                answer++;
                curE = next.end;
            }
        }

        System.out.println(answer);
    }
}
