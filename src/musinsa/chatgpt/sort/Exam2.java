package musinsa.chatgpt.sort;

import java.io.*;
import java.util.*;

public class Exam2 {
    static class Order{
        String category;
        long totalSales;
        long totalQty;
        Order(String category, long totalSales, long totalQty){
            this.category = category;
            this.totalSales = totalSales;
            this.totalQty = totalQty;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            주문 로그로 베스트 카테고리 TOP K 뽑기
            각 로그는 주문 1건의 아이템 1줄, 같은 주문이 여러 줄로 나뉠 수 있음

            orderId, category, price, qty, discount, status

            1. status가 PAID인 항목만 매출로 인정(CANCELED, REFUNDED는 무시)
            2. 각 항목의 매출은
            - floor(price * qty * (100 - discount) / 100) 으로 계산
            3. 카테고리별 매출 합계를 구함

            상위 K개 출력
            1. 카테고리 총매출 내림차순
            2. PAID 아이템의 총수량(qty 합) 내림차순
            3. category 사전순 오름차순

            K개 미만의 카테고리만 존재하면 존재하는 만큼만 출력
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, long[]> map = new HashMap<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String category = st.nextToken();
            long price = Long.parseLong(st.nextToken());
            long qty = Long.parseLong(st.nextToken());
            long discount = Long.parseLong(st.nextToken());
            String status = st.nextToken();

            if(status.equals("PAID")){
                long sales = price * qty * (100 - discount) / 100;
                if(map.get(category) != null){
                    long[] c = map.get(category);
                    c[0] += sales;
                    c[1] += qty;
                    map.put(category, c);
                }else{
                    map.put(category, new long[]{sales, qty});
                }
            }
        }

        Order[] arr = new Order[map.size()];
        int idx = 0;
        for(Map.Entry<String, long[]> entry : map.entrySet()){
            Order o = new Order(entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
            arr[idx] = o;
            idx++;
        }

        Arrays.sort(arr, (a, b) -> {
            int c1 = Long.compare(b.totalSales, a.totalSales);
            if(c1 != 0) return c1;
            int c2 = Long.compare(b.totalQty, a.totalQty);
            if(c2 != 0) return c2;
            return a.category.compareTo(b.category);
        });

        K = Math.min(K, arr.length);
        for(int i=0; i<K; i++){
            bw.write(arr[i].category + " " + arr[i].totalSales + " " + arr[i].totalQty + "\n");
        }
        bw.flush();
        bw.close();
    }
}
