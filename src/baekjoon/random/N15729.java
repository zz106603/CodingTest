package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N15729 {
    static int[] basic;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        앞에는 일렬로 놓여진 N개의 버튼이 모두 불이 꺼진 상태로 있다.
        0 또는 1로 구성되어 있는 N자리 수가 적힌 쪽지가 있다.
        0은 불이 꺼진 버튼, 1은 불이 켜진 버튼을 뜻한다.
        불이 켜져 있는 버튼을 누르면 불이 꺼지고, 불이 꺼져 있는 버튼을 누르면 불이 켜진다.
        버튼을 누르면 그 버튼 뿐만이 아닌 오른쪽 두 개의 버튼도 같이 눌린다.
        7
        0 0 1 0 0 1 0

        0 0 1 1 1 0 0

        0 0 1 0 0 1 0
         */

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        basic = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            if(basic[i] != arr[i]){
                if(i == N-1){
                    change(i);
                }else if(i == N-2){
                    change(i);
                    change(i+1);
                }else{
                    change(i);
                    change(i+1);
                    change(i+2);
                }

                ans++;
            }
        }

        System.out.println(ans);

    }

    public static void change(int idx){
        if(basic[idx] == 0){
            basic[idx] = 1;
        }else{
            basic[idx] = 0;
        }
    }
}
