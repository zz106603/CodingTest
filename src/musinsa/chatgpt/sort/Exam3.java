package musinsa.chatgpt.sort;

import java.io.*;
import java.util.*;

public class Exam3 {
    static class Coupon{
        String couponCode;
        long totalDiscount;
        long usedCount;
        long uniqueUsers;
        public Coupon(String couponCode, long totalDiscount, long usedCount, long uniqueUsers){
            this.couponCode = couponCode;
            this.totalDiscount = totalDiscount;
            this.usedCount = usedCount;
            this.uniqueUsers = uniqueUsers;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            쿠폰 성과 TOP K
            쿠폰 사용 로그, 각 로그는 쿠폰 적용 1건, 같은 주문에 여러 쿠폰이 사용될 수 있음

            ts, orderId, userId, couponCode, category, itemPrice, qty, discountType(P, A), discountValue, status

            1. 기간 필터: 입력으로 주어지는 [startDate, endDate] 범위 안의 로그만 고려
            2. status가 USED만 인정
            3. 중복 제거: 같은 주문에서 여러번 기록
            - 아래 키가 완전히 같으면 첫 1건만 인정, 나머지는 무시
            - orderId + couponCode
            4. 할인 계산
            - 아이템 총액 gross = itemPrice * pty
            - 할인액 disc
            P : floor(gross * discountValue / 100)
            A : discountValue
            단, 할인액은 gross를 넘을 수 없음 - disc = min(disc, gross)
            최종 결제액 net = gross - disc (출력에는 net이 아니라 할인액을 집계)

            couponCode 별로 다음을 집계
            totalDiscount: 할인액 합
            usedCount: 중복 제거된 후 인정된 USED 건수
            uniqueUsers: 해당 쿠폰을 사용한 유저 수(중복 제거 후 기준)

            1. totalDoscount 내림차순
            2. uniqueUsers 내림차순
            3. couponCode 오름차순

            couponCode totalDiscount usedCount uniqueUsers 으로 출력
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long startDate = Long.parseLong(st.nextToken().replaceAll("-", ""));
        long endDate = Long.parseLong(st.nextToken().replaceAll("-", ""));

        // 필터 1: [startDate, endDate] && status = USED

        Map<String, long[]> map = new HashMap<>();
        Map<String, Set<String>> userMap = new HashMap<>();
        Set<String> dupChk = new HashSet<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            Long ts = Long.parseLong(st.nextToken().replaceAll("-", ""));
            String orderId = st.nextToken();
            String userId = st.nextToken();
            String couponCode = st.nextToken();
            st.nextToken();
            long itemPrice = Long.parseLong(st.nextToken());
            long qty = Long.parseLong(st.nextToken());
            String discountType = st.nextToken();
            long discountValue = Long.parseLong(st.nextToken());
            String status = st.nextToken();

            if(ts >= startDate && ts <= endDate && status.equals("USED")){
                // 중복 제거
                String key = orderId + "|" + couponCode;
                if(dupChk.contains(key)) continue;

                // 중복 키
                dupChk.add(key);
                // 중복 사용자
                Set<String> uSet;
                uSet = (userMap.get(couponCode) == null) ? new HashSet<>() : userMap.get(couponCode);
                uSet.add(userId);
                userMap.put(couponCode, uSet);

                // 할인 계산
                long gross = itemPrice * qty;
                long disc = 0;
                if(discountType.equals("P")){
                    disc = gross * discountValue / 100;
                }else{
                    disc = discountValue;
                }
                disc = Math.min(disc, gross);

                if(map.containsKey(couponCode)){
                    long[] cur = map.get(couponCode);
                    cur[0] += disc;
                    cur[1] += 1;
                    map.put(couponCode, cur);
                }else{
                    map.put(couponCode, new long[]{disc, 1});
                }
            }
        }

        Coupon[] arr = new Coupon[map.size()];
        int idx = 0;
        for(Map.Entry<String, long[]> entry : map.entrySet()){
            String coupon = entry.getKey();
            long[] v = entry.getValue();
            long uniqueUsers = userMap.get(coupon).size();
            arr[idx++] = new Coupon(coupon, v[0], v[1], uniqueUsers);
        }

        Arrays.sort(arr, (a, b) -> {
            int c1 = Long.compare(b.totalDiscount, a.totalDiscount);
            if(c1 != 0) return c1;
            int c2 = Long.compare(b.uniqueUsers, a.uniqueUsers);
            if(c2 != 0) return c2;
            return a.couponCode.compareTo(b.couponCode);
        });

        K = Math.min(K, arr.length);
        for(int i=0; i<K; i++){
            bw.write(arr[i].couponCode + " " + arr[i].totalDiscount + " " + arr[i].usedCount + " " + arr[i].uniqueUsers + "\n");
        }
        bw.flush();
        bw.close();
    }
}
