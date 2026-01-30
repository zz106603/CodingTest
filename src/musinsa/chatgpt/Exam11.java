package musinsa.chatgpt;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
               1. 상품 합계 = 모든 상품의 (가격 x 수량) 합
               2. 쿠폰 할인 적용
               - 쿠폰 타입이 RATE 이면: 상품 합계 x (할인율 / 100) 만큼 할인
               - 쿠폰 타입이 AMOUNT 이면: 정액만큼 할인
               - 단, 할인액의 상품 합계를 초과할 수 없다.
               3. 배송비 계산
               - 쿠폰 적용 후 금액이 FREE_SHIPPING_THRESHOLD 이상이면 배송비는 0
               - 아니면 배송비는 SHIPPING_FEE
               4. 포인트 사용
               - 포인트는 (쿠폰 적용 후 금액 + 배송비)에서 차감
               - 단, 포인트는 결제 금액을 초과해서 사용할 수 없음
               5. 최종 결제 금액을 출력(0 이상)
         */

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 1. 총 합 계산
        long amount = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            long price = Integer.parseInt(st.nextToken());
            long quantity = Integer.parseInt(st.nextToken());

            amount += price * quantity;
        }

        // 2. 쿠폰 할인 적용
        st = new StringTokenizer(br.readLine());
        String couponType = st.nextToken();
        int couponValue = Integer.parseInt(st.nextToken());

        long sales = 0;
        if(couponType.equals("RATE")){
            sales = amount * couponValue / 100;
        }else if(couponType.equals("AMOUNT")){
            sales = couponValue;
        }
        sales = Math.min(sales, amount);
        amount -= sales;

        // 3. 배송비 적용
        st = new StringTokenizer(br.readLine());
        long shippingThreshold = Long.parseLong(st.nextToken());
        long shippingFee = Long.parseLong(st.nextToken());

        if(amount < shippingThreshold) amount += shippingFee;

        // 4. 포인트 적용
        long point = Long.parseLong(br.readLine());
        point = Math.min(point, amount);
        amount -= point;

        bw.write(String.valueOf(amount));
        bw.flush();
        bw.close();
    }
}
