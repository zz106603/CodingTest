package musinsa.chatgpt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exam4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
            배송비 포함 결제 금액
            price, category

            1. 상품 가격 합 S
            2. 배송비는 기본 3000원
            3. 아래 조건을 만족하면 0원
            - A : S >= 50000
            - B : 서로 다른 카테고리 종류 수가 3개 이상
            4. 추가로 카테고리가 fragile (깨짐 주의)인 상품이 하나라도 있으면, 위 규칙과 무관하게 배송비에 2000원 추가
            무료 배송이어도 2000원 추가
         */

        int N = Integer.parseInt(br.readLine());

        long delivery = 3000;
        boolean fragileFlag = false;
        long totalPrice = 0;
        Set<String> categorySet = new HashSet<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String category = st.nextToken();

            totalPrice += price;
            categorySet.add(category);

            if(category.equals("fragile")) fragileFlag = true;
        }

        if(totalPrice >= 50000 || categorySet.size() >= 3){
            delivery = 0;
        }

        if(fragileFlag) delivery += 2000;

        System.out.println(totalPrice + delivery);
    }
}
