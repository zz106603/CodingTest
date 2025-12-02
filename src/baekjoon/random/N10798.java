package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] cArr = new char[5][15];
        for(int i=0; i<5; i++){
            for(int j=0; j<15; j++){
                cArr[i][j] = '#';
            }
        }

        for(int i=0; i<5; i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0; j<c.length; j++) cArr[i][j] = c[j];
        }

        for(int i=0; i<15; i++){
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<5; j++){
                if(cArr[j][i] != '#'){
                    flag = true;
                    sb.append(cArr[j][i]);
                }
            }

            if(flag) bw.write(sb.toString());
            else break;
        }

        bw.flush();
        bw.close();

    }
}
