package musinsa.gemini;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam1 {
    static class Product{
        String product;
        int amount;
        public Product(String product, int amount){
            this.product = product;
            this.amount = amount;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            무신사 블랙프레이데이 결제 시스템
            장바구니 정보를 바탕으로 할인 정책과 배송비를 적용한 최종 결제 금액과, 영수증을 구해라

            1. 할인
            - 상품은 가격과 할인율을 가짐
            - 할인 가격 = 원가 * (100-할인율)/100
            - 소수점 이하 버림
            2. 전체 쿠폰 사용
            - 상품별 할인이 끝난 모든 상품 금액의 합계에서 쿠폰 할인 금액을 뺌
            - 합계가 0원 미만이면 0원으로 처리
            3. 배송비 계산
            - 쿠폰 적용 후의 최종 합계 금액이 50000원 이상이면 무료 배송
            - 미만이면 3000원 추가
            4. 정렬
            - 할인 적용 후 가격 내림차순
            - 상품명 오름차순

            상품명, 원가, 할인율
            상품명(할인된가격)
         */

        int N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        // 1. 할인
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String product = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            int sales = Integer.parseInt(st.nextToken());

            int amount = price * (100-sales)/100;
            map.put(product, map.getOrDefault(product, 0) + amount);
        }

        // 할인 적용된 상품 Product 객체 저장 및 총 가격 저장
        int totalAmount = 0;
        Product[] arr = new Product[map.size()];
        int idx = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String product = entry.getKey();
            int amount = entry.getValue();
            totalAmount += amount;
            arr[idx++] = new Product(product, amount);
        }

        // 총 가격에 쿠폰 및 배송비 추가
        C = Math.min(C, totalAmount);
        totalAmount -= C;
        if(totalAmount > 0 && totalAmount < 50000) totalAmount += 3000;

        // 정렬
        Arrays.sort(arr, (a, b) ->{
            int c1 = Integer.compare(b.amount, a.amount);
            if(c1 != 0) return c1;
            return a.product.compareTo(b.product);
        });

        // 출력
        bw.write(totalAmount + "\n");
        for(Product p : arr){
            bw.write(p.product + "(" + p.amount + ")\n");
        }

        bw.flush();
        bw.close();
    }
}
