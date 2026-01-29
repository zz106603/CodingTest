package musinsa;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            주문 로그 N개
            orderId(String), status(OK, CANCEL, PENDING), amount(int)

            1. 같은 orderId가 여러 번 등장할 수 있음. 가장 마지막 로그만 유효함
            2. 마지막 로그의 status가 OK인 주문만 매출로 포함
            3. CANCEL, PENDING은 매출에 포함하지 않음
         */

        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String orderId = st.nextToken();
            String status = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());

            if(status.equals("OK")){
                map.put(orderId, amount);
            }else{
                map.put(orderId, 0);
            }
        }

        long ans = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            ans += entry.getValue();
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
