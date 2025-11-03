package baekjoon.random;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class N1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int num = 1;
        boolean flag = true;

        for(int i=0; i<N; i++){
            int target = arr[i];

            while(num <= target){
                st.push(num);
                num++;
                sb.append("+").append("\n");
            }

            if(st.peek() != target){
                flag = false;
                break;
            }

            st.pop();
            sb.append("-").append("\n");

        }

        if(flag) System.out.println(sb.toString());
        else System.out.println("NO");
    }
}
