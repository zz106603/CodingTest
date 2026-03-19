package baekjoon.random;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class N1475 {
    static Map<Integer, Integer> numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            한 세트에 0번부터 9번까지 들어있음
            방 번호가 주어졌을 때, 필요한 세트의 최솟값
            (6이랑 9는 같은거)
         */

        int answer = 0;

        String str = br.readLine();
        int[] count = new int[10];

        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i) - '0';
            count[num]++;
        }

        int sixNine = count[6] + count[9];
        count[6] = (sixNine + 1) / 2;
        count[9] = 0;

        for(int i=0; i<10; i++){
            answer = Math.max(count[i], answer);
        }

//        int answer = 0;
//        numbers = new HashMap<>();
//        for(int i=0; i<10; i++){
//            numbers.put(i, 0);
//        }
//
//        StringBuilder input = new StringBuilder(br.readLine());
//        while(input.length() > 0){
//            answer++;
//            plusSet();
//
//            String[] str = input.toString().split("");
//            input = new StringBuilder();
//            for(int i=0; i<str.length; i++){
//                int cur = Integer.parseInt(str[i]);
//
//                if(cur == 6 || cur == 9){
//                    if(numbers.get(6) > 0){
//                        numbers.put(6, numbers.get(6) - 1);
//                    }else if(numbers.get(9) > 0){
//                        numbers.put(9, numbers.get(9) - 1);
//                    }else{
//                        input.append(cur);
//                    }
//                }else{
//                    if(numbers.get(cur) > 0) {
//                        numbers.put(cur, numbers.get(cur) - 1);
//                    }else{
//                        input.append(cur);
//                    }
//                }
//            }
//        }


        System.out.println(answer);

    }
    public static void plusSet(){
        for(Map.Entry<Integer, Integer> entry : numbers.entrySet()){
            numbers.put(entry.getKey(), entry.getValue() + 1);
        }
    }
}
