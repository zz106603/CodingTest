package baekjoon.random;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class N10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        Deque<Character> st = new ArrayDeque<>();
        char[] in = br.readLine().toCharArray();
        for(int i=0; i<in.length; i++){
            if(in[i] == '(') {
                st.push(in[i]);
            }else{
                st.pop();
                if(in[i-1] == '('){
                    result += st.size();
                }else{
                    result += 1;
                }
            }

        }

        System.out.println(result);
    }
}
