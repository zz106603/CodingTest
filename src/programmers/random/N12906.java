package programmers.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class N12906 {
    public static void main(String[] args) {

        int[] arr = {1,1,3,3,0,1,1};

        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            if (!stack.isEmpty() && stack.peek() == num) {
                continue;
            } else {
                stack.push(num);
                list.add(num);
            }
        }

        /*
            이 부분이 이번 공부의 핵심
            List<Integer>를 기본형인 int[]로 변환하기 위해서는
            1. list를 stream로 변환
            2. stream를 mapToInt로 변환 (Integer::intValue) ex: (Long::longValue)
            3. toArray로 변환
         */
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();

        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
