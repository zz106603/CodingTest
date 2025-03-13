package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class N4659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
            발음이 가능한 패스워드를 만들어야 함
            1. 모음(a,e,i,o,u) 하나를 반드시 포함
            2. 모음이 3개 혹은 자음이 3개 연속 오면 안됨
            3. 같은 글자가 연속적으로 두번 오면 안되나, ee와 oo는 허용
a
tv
ptoui
bontres
zoggax
wiinq
eep
houctuh
end
        */

        // 모음
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;

            /*
                1. 모음이 없는 경우
                .* -> 아무 문자(.)든지 0개 이상(*) 등장 가능
             */
            if(!str.matches(".*[aeiou].*")){
                sb.append(String.format("<%s> is not acceptable.\n", str));
                continue;
            }

            /*
                2. 모음이나 자음이 3개 이상 연속 나올 경우

                연속된 3개의 boolean값이 같은지 판단
             */
            boolean three = false;
            for(int i=2; i<str.length(); i++){
                boolean flag1 = vowels.contains(str.charAt(i));
                boolean flag2 = vowels.contains(str.charAt(i-1));
                boolean flag3 = vowels.contains(str.charAt(i-2));
                if(flag1 == flag2 && flag1 == flag3){
                    three = true;
                    sb.append(String.format("<%s> is not acceptable.\n", str));
                    break;
                }
            }
            if(three) continue;

            /*
                3. 똑같은 숫자가 2개 이상 나올 경우(e, o 제외)
             */
            boolean two = false;
            for(int i=1; i<str.length(); i++){
                if(str.charAt(i) == str.charAt(i-1) && str.charAt(i) != 'e' && str.charAt(i) != 'o'){
                    sb.append(String.format("<%s> is not acceptable.\n", str));
                    two = true;
                    break;
                }
            }
            if(two) continue;

            sb.append(String.format("<%s> is acceptable.\n", str));
        }

        System.out.println(sb.toString());
    }
}
