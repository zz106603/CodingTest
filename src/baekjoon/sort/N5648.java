package baekjoon.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N5648 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Long> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());

        int count = 0;
        while(count < n){
            if(st.hasMoreTokens()){
                String token = new StringBuilder(st.nextToken()).reverse().toString();
                list.add(Long.parseLong(token));
                count++;
            }else{
                st =  new StringTokenizer(br.readLine());
            }
        }

        Collections.sort(list);

        for(long val : list){
            bw.write(val + "\n");
        }
        bw.flush();
        bw.close();
    }
}
