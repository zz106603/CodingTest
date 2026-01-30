package musinsa.chatgpt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
            장바구니 최종 결제 금액

            1. 쿠폰은 정확히 1개만 적용 가능
            2. 쿠폰 종류는 3가지 중 한 가지

            1. P x: x% 할인(정수 퍼센트, 0~100)
            - 각 상품 가격에 개별 적용 후, 할인된 가격은 내림(floor) 처리
            - 999에 10% 할인, 899.1 -> 899

            2. F x : 총액에서 x원 할인
            - 단, 최종 금액은 0 미만 불가

            3. B k : 가장 비싼 상품 k개를 50% 할인
            - 할인된 가격은 내림
            - k가 상품 개수보다 크면 가능한 만큼만 적용
         */

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b, a));

        st = new StringTokenizer(br.readLine());
        String type = st.nextToken();
        int val = Integer.parseInt(st.nextToken());

        long total = 0;
        if(type.equals("P")){
            for(int i=0; i<N; i++){
                total += (long)arr[i] * (100 - val) / 100;
            }
        }else if(type.equals("F")){
            for(int i=0; i<N; i++){
                total += arr[i];
            }
            total = Math.max(0, total - val);
        }else{
            int max = Math.min(val, N);
            for(int i=0; i<N; i++){
                if(i < max){
                    total += arr[i] / 2;
                }else{
                    total += arr[i];
                }
            }
        }

        System.out.println(total);
    }
}
