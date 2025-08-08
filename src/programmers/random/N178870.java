package programmers.random;

import java.io.*;
import java.util.StringTokenizer;

public class N178870 {
    public static void main(String[] args){

        int[] sequence = new int[]{1, 2, 3, 4, 5};
        int k = 7;

        int left = 0, right = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;

        /*
            오른차순 배열이어야 함
            left, right를 0번째 인덱스에서 시작
            1. right를 증가시키며 sum에 값을 저장
            2. sum이 k보다 커지면, 이제는 left를 증가시키며 sum에 [left]값을 제거
            3. sum = k가 되면, 더 차이가 적은 인덱스 값을 결과에 저장
         */
        while(right < sequence.length){
            sum += sequence[right];
            while(sum > k){
                sum -= sequence[left];
                left++;
            }

            if(sum == k){
                int idxDiff = right - left;
                if(idxDiff < minLen){
                    minLen = idxDiff;
                    start = left;
                    end = right;
                }
            }
            right++;
        }

        System.out.printf("[%d, %d]", start, end);

    }
}
