package baekjoon.random2;

import java.io.*;
import java.util.*;

public class N1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            String name = br.readLine();
            set.add(name);
        }

        int count = 0;
        List<String> res = new ArrayList<>();
        for(int i=0; i<M; i++){
            String name = br.readLine();
            if(set.contains(name)){
                count++;
                res.add(name);
            }
        }

        System.out.println(count);
        Collections.sort(res, (a, b) -> {
            return a.compareTo(b);
        });
        for(String s : res){
            System.out.println(s);
        }
    }
}
