package baekjoon.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class N17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        for(int i=0; i<N; i++){
            bw.write(i == N-1 ? String.valueOf(result[i]) : result[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
