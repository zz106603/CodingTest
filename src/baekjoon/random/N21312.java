package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N21312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int i=0; i<3; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num % 2 == 0) a.add(num);
            else b.add(num);
        }

        int answer = 1;

        if(!b.isEmpty()){
            for(int num : b) answer *= num;
        }else{
            for(int num : a) answer *= num;
        }

        System.out.println(answer);
    }
}
