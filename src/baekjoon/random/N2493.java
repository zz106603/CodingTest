package baekjoon.random;

import java.io.*;
import java.util.*;

public class N2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] heights = new int[N];

        StringTokenizer s = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            heights[i] = Integer.parseInt(s.nextToken());
        }

        /*
            6 9 5 7 4

            6 시작 -> 앞에 없으니까 0으로 세팅하고 {6, 1}로 스택에 저장 -> 현재 결과 0
            9 시작 -> 앞에 6이 있지만 9보다 작으므로 지워도 됨 {6, 1} 삭제 (6이 9보다 앞에 있으면 불필요한 데이터)
                   -> 0으로 세팅하고 {9, 2}로 저장 -> 현재 결과 0 0
            5 시작 -> 앞에 9가 있으므로, 위치 저장 -> 현재 결과 0 0 2
         */
        Stack<int[]> st = new Stack<>();
        for(int i=0; i<N; i++){
            int height = heights[i];

            while(!st.isEmpty()){
                if(height > st.peek()[0]){
                    st.pop();
                }else{
                    bw.write(st.peek()[1] + " ");
                    break;
                }
            }

            if(st.isEmpty()){
                bw.write(0 + " ");
            }

            st.push(new int[]{height, i+1});
        }

        bw.flush();
        bw.close();
    }
}
