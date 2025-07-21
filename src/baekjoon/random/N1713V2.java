package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class N1713V2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int limit = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<int[]> frames = new ArrayList<>();

        for(int i=0; i<K; i++){
            int student = Integer.parseInt(st.nextToken());

            boolean flag = false;
            for(int[] frame : frames){
                if(frame[0] == student){
                    frame[1]++;
                    flag = true;
                    break;
                }
            }

            if(flag) continue;

            if(frames.size() < limit){
                frames.add(new int[]{student, 0, i});
            }else{
                frames.sort((a, b) -> {
                    if(a[1] != b[1]) return a[1] - b[1];
                    return a[2] - b[2];
                });
                frames.remove(0);
                frames.add(new int[]{student, 0, i});
            }
        }

        frames.sort(Comparator.comparingInt(p -> p[0]));

        for(int[] frame : frames){
            bw.write(frame[0] + " ");
        }

        bw.flush();
        bw.close();
    }
}
