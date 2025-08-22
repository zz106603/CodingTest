package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            TODO: O(N+M) 으로 풀기 위해선 KMP 풀이법을 사용해야 함, 우선순위가 낮기에 추후에 다시 풀기로 결정
         */
        String str = br.readLine();
        String word = br.readLine();

        if(str.equals(word)){
            System.out.println(1);
        }else{
            boolean flag = false;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == word.charAt(0)){
                    int idx = i;
                    int count = 0;
                    // idx = 4
                    for(int j=0; j<word.length(); j++){
                        if(idx > str.length()-1 || word.charAt(j) != str.charAt(idx)) {
                            break;
                        }else{
                            idx++;
                            count++;
                        }
                    }
                    if(count == word.length()){
                        flag = true;
                    }
                }
                if(flag) break;
            }

            if(flag){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
