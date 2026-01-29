package musinsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
            상품 조회 로그
            userId, productId
            상품별 유효 조회 수를 계산

            1. 같은 사용자가 같은 상품을 여러 번 조회해도 1번만 카운트 함
            2. 단, userId가 guest인 경우 중복 제거하지 않고 모두 카운트 함
            3. 최종적으로 상품별 유효 조회 수를 계산
            4. 조회 수 내림차순, 같으면 productId 오름차순
         */

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String userId = st.nextToken();
            String productId = st.nextToken();

            if(userId.equals("guest")){
                map.put(productId, map.getOrDefault(productId, 0) + 1);
                continue;
            }

            String s = userId + "#" + productId;
            if(!set.contains(s)){
                set.add(s);
                map.put(productId, map.getOrDefault(productId, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            if(!a.getValue().equals(b.getValue())){
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });

        for(Map.Entry<String, Integer> li : list){
            System.out.println(li.getKey() + " " + li.getValue());
        }

    }
}
