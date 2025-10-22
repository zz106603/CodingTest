package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N2138 {
    static int N;
    static int[] curState;
    static int[] curState2;
    static int[] resState;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        curState = new int[N];
        curState2 = new int[N];
        for(int i=0; i<N; i++){
            String in = input[i];
            curState[i] = Integer.parseInt(in);
            curState2[i] = Integer.parseInt(in);
        }
        String[] input2 = br.readLine().split("");
        resState = new int[N];
        for(int i=0; i<N; i++){
            String in = input2[i];
            resState[i] = Integer.parseInt(in);
        }

        // 0번째 수정 안하고 1번부터 검사하는 경우
        int count = 0;
        boolean flag1 = false;
        for(int i=1; i<N; i++){
            if(curState[i-1] != resState[i-1]){
                change(curState, i);
                count++;
            }
        }

        if(Arrays.equals(curState, resState)) flag1 = true;

        // 0번째를 수정 할 경우
        if(curState2[0] == 0) curState2[0] = 1;
        else if(curState2[0] == 1) curState2[0] = 0;

        if(N > 1){
            if(curState2[1] == 0) curState2[1] = 1;
            else if(curState2[1] == 1) curState2[1] = 0;
        }

        int count2 = 1;
        boolean flag2 = false;
        for(int i=1; i<N; i++){
            if(curState2[i-1] != resState[i-1]){
                change(curState2, i);
                count2++;
            }
        }

        if(Arrays.equals(curState2, resState)) flag2 = true;

        if(flag1 && flag2) System.out.println(Math.min(count, count2));
        else if(flag1) System.out.println(count);
        else if(flag2) System.out.println(count2);
        else System.out.println(-1);
    }

    public static void change(int[] state, int i){
        if(state[i-1] == 0) state[i-1] = 1;
        else if(state[i-1] == 1) state[i-1] = 0;

        if(state[i] == 0) state[i] = 1;
        else if(state[i] == 1) state[i] = 0;

        if(i != N-1){
            if(state[i+1] == 0) state[i+1] = 1;
            else if(state[i+1] == 1) state[i+1] = 0;
        }
    }
}
