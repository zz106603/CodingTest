package musinsa;

import java.io.*;
import java.util.StringTokenizer;

public class Exam9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            장바구니 상품 정보
            price, category

            1. 모든 상품가격의 합 s
            2. 기본 할인 정책
            - 카테고리가 event인 상품은 개당 10% 할인(내림)
            3. 추가 할인 정책
            - 할인 적용 후 총합이 100000 이상이면 추가로 5000원 할인
            - 단, 최종 금액은 0 미만이 될 수 없음
            4. 모든 할인은 순서대로 적용
                1) event 상품 할인
                2) 총액 기준 추가 할인
         */

        int N = Integer.parseInt(br.readLine());

        long total = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long amount = Long.parseLong(st.nextToken());
            String category = st.nextToken();

            if(category.equals("event")){
                total += amount - (amount*10 / 100);
            }else{
                total += amount;
            }
        }

        if(total >= 100000){
            total -= 5000;
        }

        System.out.println(Math.max(0, total));


    }
}
