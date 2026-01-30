package musinsa.gemini;

import java.io.*;
import java.util.*;

public class Exam2 {
    static class Log{
        String type;
        String name;
        int count;
        public Log(String type, String name, int count){
            this.type = type;
            this.name = name;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            주문과 입고 로그를 처리하여 최종 재고 상태를 출력
            1. 초기 상태 : 초기 재고는 0
            2. 로그 종류
            - STOCK [상품명] [수량]: 해당 상품의 재고가 수량만큼 증가
            - ORDER [상품명] [수량]: 해당 상품의 재고를 수량만큼 감소
            3. 주문 처리 우선순위 및 예외
            - 부분 출고 금지: 주문 수량보다 현재 재고가 적다면 해당 주문은 취소
            - VIP 우선권: 상품명 뒤에 -VIP가 붙은 주문은 일반 주문보다 항상 먼저 처리되어야 함
            4. 처리 순서
            - 하루 로드가 한번에 주어짐
            - 1순위: 모든 STOCK 로그를 먼저 처리하여 재고를 확보합니다. (입고가 먼저 되어야 주문을 처리할 수 있음)
            - 2순위: ORDER 로그 중 VIP 주문들을 입력된 순서대로 처리합니다.
            - 3순위: ORDER 로그 중 일반 주문들을 입력된 순서대로 처리합니다.
            5. 최종 출력
            - 최종 재고 수량이 많은 순서(내림차순)
            - 상품명 사전순(오름차순)
         */

        int L = Integer.parseInt(br.readLine());

        List<Log> stocks = new ArrayList<>();
        List<Log> vips = new ArrayList<>();
        List<Log> nomal = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            if(type.equals("STOCK")) stocks.add(new Log(type, name, count));
            else if(name.endsWith("-VIP")) vips.add(new Log(type, name.substring(0, name.length()-4), count));
            else nomal.add(new Log(type, name, count));
        }

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<stocks.size(); i++){
            Log log = stocks.get(i);
            map.put(log.name, map.getOrDefault(log.name, 0) + log.count);
        }

        for(int i=0; i<vips.size(); i++){
            Log log = vips.get(i);
            if(map.getOrDefault(log.name, 0) >= log.count){
                map.put(log.name, map.getOrDefault(log.name, 0) - log.count);
            }
        }

        for(int i=0; i<nomal.size(); i++){
            Log log = nomal.get(i);
            if(map.getOrDefault(log.name, 0) >= log.count){
                map.put(log.name, map.getOrDefault(log.name, 0) - log.count);
            }
        }

        List<Log> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 0){
                list.add(new Log(null, entry.getKey(), entry.getValue()));
            }
        }

        if(list.isEmpty()){
            bw.write("EMPTY");
        }else{
            list.sort((a, b) -> {
                int c1 = Integer.compare(b.count, a.count);
                if(c1 != 0) return c1;
                return a.name.compareTo(b.name);
            });

            for(Log log : list){
                bw.write(log.name + " " + log.count + "\n");
            }
        }

        bw.close();

    }
}
