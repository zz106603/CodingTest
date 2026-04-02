package baekjoon.random2;

import java.io.*;
import java.util.*;

public class N9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            char[] c = br.readLine().toCharArray();

            Stack<Character> st = new Stack<>();
            st.push(c[0]);
            boolean flag = true;
            for(int j=1; j<c.length; j++){
                if(c[j] == '('){
                    st.push(c[j]);
                }else{
                    if(st.isEmpty()){
                        sb.append("NO\n");
                        flag = false;
                        break;
                    }else if(st.peek() == '('){
                        st.pop();
                    }
                }
            }
            if(flag){
                if(st.isEmpty()){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
