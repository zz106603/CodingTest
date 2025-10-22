package baekjoon.random;

import java.io.*;

public class N1347 {

    public static String changeR(String s){
        switch (s) {
            case "S" : return "L";
            case "L" : return "N";
            case "N" : return "R";
            default : return "S";
        }
    }

    public static String changeL(String c){
        switch (c) {
            case "S" : return "R";
            case "R" : return "N";
            case "N" : return "L";
            default : return "S";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");

        String[][] map = new String[100][100];
        int curX = 50;
        int curY = 50;
        map[curX][curY] = ".";

        // R, L, S, N
        String prev = "S";

        for (int i = 0; i < N; i++) {
            if (input[i].equals("R")) {
                prev = changeR(prev);
            } else if (input[i].equals("L")) {
                prev = changeL(prev);
            } else {
                if (prev.equals("S")) curX += 1;
                else if (prev.equals("R")) curY += 1;
                else if (prev.equals("L")) curY -= 1;
                else curX -= 1;

                map[curX][curY] = ".";
            }
        }

        int firstX = 100;
        int lastX = 0;
        int firstY = 100;
        int lastY = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] != null) {
                    if (map[i][j].equals(".")) {
                        firstX = Math.min(i, firstX);
                        lastX = Math.max(i, firstX);
                        firstY = Math.min(j, firstY);
                        lastY = Math.max(j, lastY);
                    }
                }
            }
        }
        for (int i = firstX; i <= lastX; i++) {
            for (int j = firstY; j <= lastY; j++) {
                if (map[i][j] == null) bw.write("#");
                else bw.write(map[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
