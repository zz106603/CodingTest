package musinsa.baekjoon;

import java.io.*;
import java.util.*;

public class N1713 {
    static class Candidate{
        int id;
        int cnt;
        int t;
        public Candidate(int id, int cnt, int t){
            this.id = id;
            this.cnt = cnt;
            this.t = t;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
           1. 학생들이 추천을 시작하기 전에 모든 사진틀은 비어있음
           2. 어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 함
           3. 비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고, 그 자리에 새롭게 추천받은 학생의 사진을 게시
           이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는 그러한 학생들 중 게시가 가장 오래된 사진을 삭제
           4. 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가
           5. 사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀜
         */

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        List<Candidate> frame = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int cur = Integer.parseInt(st.nextToken());

            Candidate found = null;
            for(Candidate c : frame){
                if(c.id == cur){
                    found = c;
                    break;
                }
            }

            if(found != null){
                found.cnt++;
                continue;
            }

            if(frame.size() < N){
                frame.add(new Candidate(cur, 1, i));
            }else{
                frame.sort((a, b) -> {
                    int c1 = Integer.compare(a.cnt, b.cnt);
                    if(c1 != 0) return c1;
                    return Integer.compare(a.t, b.t);
                });

                frame.remove(0);
                frame.add(new Candidate(cur, 1, i));
            }
        }

        frame.sort((a, b) -> Integer.compare(a.id, b.id));
        for(Candidate c : frame){
            bw.write(c.id + " ");
        }
        bw.close();

    }
}
