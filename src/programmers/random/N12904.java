package programmers.random;

import java.io.*;
import java.util.StringTokenizer;

public class N12904 {

    static char[] ch;
    static int n;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        String s = "abcdcba";
        
        /*
            가장 긴 팰린드롬
            - 거꾸로 문자열을 돌렸을 때 같은 문자열을 팰린드롬이라고 할 때, 가장 긴 팰린드롬을 찾아라.
            
            이 문제는 투포인터를 활용해야 함
            팰린드롬이 나올 경우의 수?
            홀수일 경우: 중간값을 1개로 두고 좌 우로 탐색
            짝수일 경우: 중간값을 2개로 두고 좌 우로 탐색
         */

        n = s.length();
        ch = new char[n];
        for(int i=0; i<n; i++){
            ch[i] = s.charAt(i);
        }

        for(int i=0; i<n; i++){
            center(i, i); // left, right, 홀수
            center(i, i+1); // left, right, 짝수
        }

        System.out.println(answer);
    }

    public static void center(int left, int right){
        while(left >= 0 && right < n && ch[left] == ch[right]){
            answer = Math.max(answer, right - left + 1);
            left--;
            right++;
        }
    }
}
