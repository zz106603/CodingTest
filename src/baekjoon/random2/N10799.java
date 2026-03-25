package baekjoon.random2;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class N10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        (((()())(())()))(())

        (((()())(())()))(())
         */

        int answer = 0;
        char[] input = br.readLine().toCharArray();

        Stack<Character> st = new Stack<>();

        for(int i=0; i<input.length; i++){
            if(input[i] == '('){
                st.push(input[i]);
            }else{
                st.pop();
                if(input[i-1] == '('){
                    answer += st.size();
                }else{ // 바로 왼쪽이 괄호가 아니므로 레이저가 아님 -> 오른쪽 남아있는 괄호
                    answer += 1;
                }
            }
        }

        System.out.println(answer);

    }
}
