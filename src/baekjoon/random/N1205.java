package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
            노래마다 랭크 리스트 (게임할 때 마다 얻는 점수가 비오름차순 저장)
            등수는 위에서부터 몇번 째, 같은 점수가 있을 때는 가장 작은 등수

            100, 90, 90, 80
             1    2   2  4

            점수의 개수 P
            리스트에 있는 점수 N개 -> 비오름차순
            태수의 새로운 점수

            새로운 점수가 랭킹 몇등?
            랭킹 리스트가 꽉 차 있으면 새 점수가 이전 점수보다 더 좋을 때만 바뀜

            10 1 10
            10 9 8 7 6 5 4 3 3 0
         */

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        if(N > 0){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
        }

        int rank = 1;
        int answer = -1;
        for(int i=1; i<=P; i++){
            if(arr.length >= i){
                if(arr[i-1] < T){
                    answer = rank;
                    break;
                }else{
                    if(arr[i-1] != T){
                        rank++;
                    }
                }
            }else{
                answer = rank;
                break;
            }
        }

        System.out.println(answer);
    }
}
