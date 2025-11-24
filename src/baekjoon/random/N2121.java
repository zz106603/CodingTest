package baekjoon.random;

import java.io.*;
import java.util.*;

public class N2121 {
    static int N,A,B;
    static int res = 0;

    static class Point{
        int x;
        int y;
        Point(int x, int y){this.x = x; this.y = y;}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Point[] arr = new Point[N];
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
            set.add(x + " " + y);
        }

        for(Point p : arr){
            if(set.contains((p.x+A) + " " + p.y) &&
                set.contains(p.x + " " +  (p.y+B)) &&
                set.contains((p.x+A) + " " +  (p.y+B))){
                res++;
            }
        }

        System.out.println(res);
    }
}
