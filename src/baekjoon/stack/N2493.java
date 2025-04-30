package baekjoon.stack;

import java.io.*;
import java.util.*;

public class N2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] heights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }

        /*
            1. 높이와 위치를 배열로 저장
            2. 하나씩 push해서 stack에 남아있는 값들과 비교
            2-1. stack에 더 큰 값이 있을때까지 반복(pop)
            2-2. 큰 값이 존재한다면 그 값의 위치를 반환
         */
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<N; i++){
            int height = heights[i];

            while(!stack.isEmpty()){
                if(stack.peek()[0] < height){
                    stack.pop();
                }else{
                    bw.write(stack.peek()[1] + " ");
                    break;
                }
            }

            if(stack.isEmpty()){
                bw.write("0 ");
            }

            stack.push(new int[]{height, i+1});
        }

        bw.flush();
        bw.close();
    }
}
