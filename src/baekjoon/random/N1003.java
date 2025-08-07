package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        /*
            일단 피보나치 값이랑 비교해보면서 0이 몇번 나오는지, 1이 몇번 나오는지 규칙을 찾아보자

                    0   1 숫자
            f(0) =  1   0 = 1
            f(1) =  0   1 = 1
            f(2) =  1   1 = 2
            f(3) =  1   2 = 3
            
            n-1, n-2의 각 0과 1이 나온 값을 더하면 결과가 나오는 규칙을 찾음

            결론은
            f(n-1)[0] + f(n-2)[0] = f(n)[0] = 0이 나온 개수
            f(n-1)[1] + f(n-2)[1] = f(n)[1] = 0이 나온 개수
         */

        for(int k=0; k<N; k++){
            int num = Integer.parseInt(br.readLine());

            int[][] count = new int[num+1][2];

            if(num == 0){
                count[0][0] = 1;
                count[0][1] = 0;
            }else if(num == 1){
                count[1][0] = 0;
                count[1][1] = 1;
            }else{
                // f(0)은 0이 1번, f(1)은 1이 1번
                count[0][0] = 1;
                count[0][1] = 0;
                count[1][0] = 0;
                count[1][1] = 1;

                for(int i=2; i<=num; i++){
                    count[i][0] = count[i-1][0] + count[i-2][0];
                    count[i][1] = count[i-1][1] + count[i-2][1];
                }
            }

            bw.write(count[num][0] + " " + count[num][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
