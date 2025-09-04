package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N19948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String poem = br.readLine();
        int life = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
            시는 대문자, 소문자 알파벳, 빈칸
            시에 나오는 단어들의 첫 글자를 대문자로 바꾼 뒤 순서대로 이어서 제목을 만듬
            만약 시의 내용이 'There is no cow level' 이라면 시의 제목은 'TINCL'이 됨

            키보드 자판 수명이 있음
            대신 같은 알파벳은 연속으로 누를 수 있어서 1번으로 침

            이 문제의 핵심!
            0. 알파벳 배열에 값들을 0으로 설정
            1. 스페이스바 제한을 확인해야 함(공백)
            2. 키보드 제한을 확인해야 함(알파벳)
            3. 연속된 공백이나 알파벳(a, Z)는 한 번으로 처리해야 하기 때문에, prev 사용
              3-1. prev나 cur는 둘 다 소문자로 변환하여 비교하면 편함
            4. 가장 핵심은 알파벳 입력 검증 뿐만 아니라, 제목이 만들어지면 그것도 키보드 제한을 통과하는지 확인 필요

         */
        int[] alp = new int[26];
        for(int i=0; i<26; i++){
            alp[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        char prev = '\0';
        sb.append(Character.toUpperCase(poem.charAt(0)));
        for(int i=0; i<poem.length(); i++){
            char cur = poem.charAt(i);
            if(cur == ' '){ // 공백
                if(prev != ' '){
                    if(life == 0){
                        System.out.println(-1);
                        return;
                    }
                    life--;
                }
            }else{ // 알파벳
                if(prev == ' ') sb.append(Character.toUpperCase(cur));
                char lower = Character.toLowerCase(cur);
                if(Character.toLowerCase(prev) != lower){
                    int idx = lower - 'a';
                    if(alp[idx] == 0){
                        System.out.println(-1);
                        return;
                    }
                    alp[idx]--;
                }
            }
            prev = cur;
        }

        String title = sb.toString();
        char prevTitle = '\0';
        for(int i=0; i<title.length(); i++){
            char cur = title.charAt(i);
            char lower = Character.toLowerCase(cur);
            if(Character.toLowerCase(prevTitle) != lower){
                int idx = lower - 'a';
                if(alp[idx] == 0){
                    System.out.println(-1);
                    return;
                }
                alp[idx]--;
            }
            prevTitle = cur;
        }

        System.out.println(title);

    }
}
