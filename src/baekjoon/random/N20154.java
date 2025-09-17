package baekjoon.random;

import java.io.*;

public class N20154 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] map = {
                3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1
        }; // A~Z

        char[] s = br.readLine().toCharArray();
        long sum = 0;
        for(char ch : s) sum += map[ch - 'A'];

        int ans = (int)(sum%10);
        if(ans % 2 == 0){
            System.out.println("You're the winner?");
        }else{
            System.out.println("I'm a winner!");
        }
    }
}
