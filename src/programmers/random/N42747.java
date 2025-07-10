package programmers.random;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class N42747 {
    public static void main(String[] args){
        int[] citations = {3, 0, 6, 1, 5};

        /*
            Integer[]과 List<Integer> 변환 차이
         */
        Integer[] boxedArr = Arrays.stream(citations)
                .boxed()
                .toArray(Integer[]::new);

        List<Integer> boxedList = Arrays.stream(citations)
                        .boxed()
                        .collect(Collectors.toList());

        Arrays.sort(boxedArr, Collections.reverseOrder());
        boxedList.sort(Collections.reverseOrder());

        for(int tmp : boxedList){
            System.out.println(tmp);
        }

        int ans = citations.length;
        /*
            6 5 3 1 0
            0 1 2 3 4 <- idx
         */
        for(int i=0; i<citations.length; i++) {
            if(citations[i] <= i){
                ans = i;
            }
        }

        System.out.println(ans);


    }
}
