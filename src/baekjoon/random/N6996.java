package baekjoon.random;

import java.io.*;
import java.util.*;

public class N6996 {
    /*
        이 문제에서의 포인트
        1. 두 문자열을 비교하는 메서드를 통해 코드 간략화
        2. String 문자열을 Char[]로 변경(.toCharArray())
        3. 변경된 배열을 이용하여 정렬
        4. 정렬된 배열을 비교할 때, 그냥 equals()가 아닌 Arrays.equals()를 사용해야 주소 비교가 아닌 값 비교가 가능
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (isArgumentBySorting(a, b)) {
                bw.write(a + " & " + b + " are anagrams.\n");
            } else {
                bw.write(a + " & " + b + " are NOT anagrams.\n");
            }

        }
        bw.flush();
        bw.close();
    }

    private static boolean isArgumentBySorting(String a, String b){
        if(a.length() != b.length()) return false;

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        Arrays.sort(aChars);
        Arrays.sort(bChars);

        return Arrays.equals(aChars, bChars);
    }
}
