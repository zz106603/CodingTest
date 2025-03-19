package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
7 Y
lms0806
lms0806
exponentiale
lms0806
jthis
lms0806
leo020630
 */
public class N25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int checkCount = game.equals("Y") ? 1 : game.equals("F") ? 2 : 3;

        HashSet<String> set = new HashSet<>();

        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        System.out.println(set.size()/checkCount);
    }
}
