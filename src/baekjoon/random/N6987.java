package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N6987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        A	4	1	0
        B	3	0	2
        C	4	1	0
        D	1	1	3
        E	0	0	5
        F	1	1	3

        0 1 0
        0 0 0
        0 1 0
        0 1 0
        0 0 0
        0 1 0

        1. 팀 마다 무승부를 빼서 0이 되어야 함
        - 무승부를 일단 다 뺀다
        - 0보다 크면 불가능

        0	0	0
        0	0	0
        0	0	0
        0	0	0
        0	0	0
        0	0	1
         */

        for(int k=0; k<4; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[][] arr = new int[6][3];
            for(int i=0; i<6; i++){
                for(int j=0; j<3; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            for(int i=0; i<6; i++){
//                for(int j=0; j<3; j++){
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }

            // 1. 무승부 먼저 검사
            int mid = 0;
            for(int i=0; i<6; i++){

                if(mid == 0 && arr[i][1] != 0){
                    mid = arr[i][1];
                }else{
                    mid = mid - arr[i][1];
                }
            }
            if(mid != 0) {
                bw.write("0 ");
                continue;
            }

            // 2. 승, 패 크기를 비교해서 뺀다.
            for(int i=0; i<6; i++){
                for(int j=0; j<6; j++){
                    if(i == j) continue;
                    if(arr[i][0] >= arr[j][2]){
                        arr[i][0] = arr[i][0] - arr[j][2];
                        arr[j][2] = 0;
                    }else{
                        arr[j][2] = arr[j][2] - arr[i][0];
                        arr[i][0] = 0;
                    }
                }
            }

            if(arr[5][0] == arr[5][2]) {
                bw.write("1 ");
            }else{
                bw.write("0 ");
            }

//            System.out.println();
//            for(int i=0; i<6; i++){
//                for(int j=0; j<3; j++){
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
        }

        bw.flush();
    }
}
