package baekjoon.random;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N4690 {

    static class Cube{
        int a;
        int b;
        int c;
        int d;
        Cube(int a, int b, int c, int d){this.a = a; this.b = b; this.c = c; this.d = d;}
    }

    static List<Cube> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        for(int b=2; b<=100; b++){
            for(int c=b+1; c<=100; c++){
                for(int d=c+1; d<=100; d++){
                    long b3 = (long)b*b*b;
                    long c3 = (long)c*c*c;
                    long d3 = (long)d*d*d;
                    long sum = b3 + c3 + d3;

                    // 세제곱근 값 구하기
                    int a = (int)Math.round(Math.cbrt(sum));
                    if(a <= 100 && a > d && (long) a*a*a == sum){
                        list.add(new Cube(a, b, c, d));
                    }
                }
            }
        }

        list.sort((a, b) -> a.a - b.a);

        for(Cube c : list){
            sb.append("Cube = ").append(c.a).append(", Triple = (").append(c.b).append(",").append(c.c).append(",").append(c.d).append(")\n");
        }

        System.out.println(sb.toString());
    }
}
