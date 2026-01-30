package musinsa.chatgpt;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
           행동 로그
           userId, action(ADD, REMOVE, UPDATE), value
           1. 같은 userId는 여러 번 등장 가능
           2. 각 userId별로 마지막 action만 유효함
           3. 마지막 action이
           - ADD: value를 합계에 포함
           - UPDATE: value를 합계에 포함
           - REMOVE: 해당 userId는 합계에서 제외
         */

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String userId = st.nextToken();
            String action = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if(action.equals("ADD") || action.equals("UPDATE")){
                map.put(userId, value);
            }else{
                map.put(userId, 0);
            }
        }

        long ans = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            ans += entry.getValue();
        }

        System.out.println(ans);

    }
}
