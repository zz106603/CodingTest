package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class N1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int val = 1;
        while(val <= N || !st.isEmpty()){
            if(!st.isEmpty() && st.peek() == arr[idx]){
                st.pop();
                sb.append("-\n");
                idx++;
            }else if(val <= N){
                st.push(val++);
                sb.append("+\n");
            }else{
                sb.setLength(0);
                sb.append("NO\n");
                break;
            }
        }

        System.out.println(sb.toString());
    }
}
