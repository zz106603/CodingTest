package programmers.random;

import java.util.Arrays;

public class N42746 {
    public static void main(String[] args){

        int[] numbers = {3, 30, 34, 5, 9};

        Integer[] boxed = Arrays.stream(numbers)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(boxed, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));

        StringBuilder sb = new StringBuilder();
        for(int num : boxed){
            sb.append(num);
        }

        if(sb.toString().charAt(0) == '0'){
            System.out.println(0);
        }else{
            System.out.println(sb.toString());
        }
    }
}
