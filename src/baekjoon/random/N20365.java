package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            8
            BBRBRBBR

            8
            BRBBBBBB
            연속된 구간의 길이가 더 많은걸 먼저 수행하면 됨
            B는 2구간, R는 1구간
            구간이 긴 것부터 색칠 후에, 구간이 짧은 걸 색칠하면 정답
         */

        int n = Integer.parseInt(br.readLine());
        int b = 0;
        int r = 0;
        boolean bFlag = false;
        boolean rFlag = false;
        String line = br.readLine();
        for(int i=0; i<n; i++){
            char c = line.charAt(i);
            if(c == 'B' && !bFlag) {
                bFlag = true;
                rFlag = false;
                b++;
            }else if(c == 'R' && !rFlag){
                rFlag = true;
                bFlag = false;
                r++;
            }
        }

        System.out.println(Math.min(b, r) + 1);
    }
}
