package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N4097 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            창업한지 N일
            가장 많은 돈을 번 구간
            1일: -3
            2일: 4
            3일: 9
            4일: -2
            5일: -5
            6일: 8
            2 ~ 6 일이고 총 수입은 14 부분합의 최대값
            - kadane 알고리즘 사용
            - 현재 원소를 새로 시작할건지, 이어붙일건지
            - current = Math.max(arr[i], current[i] + arr[i]);
            - maxSum = Math.max(maxSum, current)
         */

        String line;
        while((line = br.readLine()) != null){
            int n = Integer.parseInt(line);
            if(n == 0) break;

            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }

            int current = arr[0];
            int maxSum = arr[0];

            for(int i=1; i<n; i++){
                /*
                    current = 현재의 누적 값 vs 새로운 값
                    maxSum = 만약, 새로운 값이 더 커서 누적합이 초기화되어도, 이 전에 계산했던 누적합이 더 클 수가 있음
                    따라서, maxSum은 current가 계산될 때 마다 비교해서 업데이트
                 */
                current = Math.max(arr[i], current + arr[i]);
                maxSum = Math.max(maxSum, current);
            }

            bw.write(maxSum+"\n");
        }

        bw.flush();
        bw.close();
    }
}
