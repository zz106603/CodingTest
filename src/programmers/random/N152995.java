package programmers.random;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N152995 {
    public static void main(String[] args) throws IOException {

        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};

        int answer = 0;

        int[] won = scores[0];
        int wonSum = won[0] + won[1];

        Arrays.sort(scores, (a, b) -> {
           if(a[0] == b[0]) return a[1] - b[1];
           return b[0] - a[0];
        });

        int maxSecond = 0;
        List<Integer> sumList = new ArrayList<>();
        for(int[] s : scores){
            if(s[1] < maxSecond){
                if(won[0] == s[0] && won[1] == s[1]){
                    System.out.println(-1);
                    return;
                }
            }else{
                maxSecond = Math.max(maxSecond, s[1]);
                sumList.add(s[0] + s[1]);
            }
        }

        sumList.sort((a, b) -> b - a);
        int rank = 1;
        for(int sum : sumList){
            if(sum > wonSum) rank++;
            else break;
        }

        System.out.println(rank);
    }
}
