package baekjoon.random;

import java.io.*;
import java.util.*;

public class N1713 {

    public static class Photo{
        int std;
        int count;
        int time;

        public Photo(int std, int time){
            this.std = std;
            this.count = 1;
            this.time = time;
        }

        public int getStd(){
            return this.std;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            3
            9
            2 1 4 3 5 6 2 7 2

            월드초등학교 학생회장 후보는 일정 기간 동안 전체 학생의 추천에 의하여 정해진 수만큼 선정된다. 그래서 학교 홈페이지에 추천받은 학생의 사진을 게시할 수 있는 사진틀을 후보의 수만큼 만들었다. 추천받은 학생의 사진을 사진틀에 게시하고 추천받은 횟수를 표시하는 규칙은 다음과 같다.

            1. 학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
            2. 어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
            3. 비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고, 그 자리에 새롭게 추천받은 학생의 사진을 게시한다.
            이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는 그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
            4. 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
            5. 사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀐다.
            후보의 수 즉, 사진틀의 개수와 전체 학생의 추천 결과가 추천받은 순서대로 주어졌을 때, 최종 후보가 누구인지 결정하는 프로그램을 작성하시오.
         */
        int limit = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Photo> frames = new ArrayList<>();

        for(int i=0; i<K; i++){
            int student = Integer.parseInt(st.nextToken());

            // 1. frames안에 일치하는 학생이 있는지 찾아서 일치하면 count 증가시키고 다음 학생으로 진행
            boolean found = false;
            for(Photo p : frames){
                if(p.std == student){
                    p.count++;
                    found = true;
                    break;
                }
            }

            if(found) continue;

            // 2. frames안에 일치하는 학생이 없으면
            //  2-1. 프레임틀 개수보다 작으면 바로 넣는다.
            //  2-2. 프레임틀 개수보다 많을 경우에는 1.count, 2.time 순서대로 정렬 후 맨 앞 제거 및 추가
            if(frames.size() < limit){
                frames.add(new Photo(student, i));
            }else{
                frames.sort((a, b) -> {
                    if(a.count != b.count) return a.count - b.count;
                    return a.time - b.time;
                });
                frames.remove(0);
                frames.add(new Photo(student, i));
            }
        }

        // std 오름차순으로 정렬
        // 두 방법 다 가능, 두 번째 방법은 메서드 정렬
        frames.sort(Comparator.comparingInt(p -> p.std));
        frames.sort(Comparator.comparingInt(Photo::getStd));

        for(Photo p : frames){
            bw.write(p.std + " ");
        }

        bw.flush();
        bw.close();
    }
}
