package programmers.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N42840 {
    public static void main(String[] args){

        int[] answers = new int[]{1, 3, 2, 4, 2};

        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        /*
            1. 각 번호에서 몇개를 맞췄는지 증가시킨다. score++
            2. 각 번호에서 최대 맞춘 개수를 구한다. max
            3. 그 최대값과 맞춘 개수가 동일하면 결과에 저장한다. answer
            4. List를 Array로 변환하여 return한다.
         */
        for(int i=0; i<answers.length; i++){
            if(answers[i] == one[i%one.length]) score[0]++;
            if(answers[i] == two[i%two.length]) score[1]++;
            if(answers[i] == three[i%three.length]) score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(max == score[i]) answer.add(i + 1);
        }

        int[] ans = answer.stream().mapToInt(Integer::intValue).toArray();

        for(int n : ans){
            System.out.print(n + ", ");
        }

    }
}
