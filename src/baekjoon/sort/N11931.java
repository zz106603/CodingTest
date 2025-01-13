package baekjoon.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N11931{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        Collections.sort(list);

        for(int num : list){
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }
}
