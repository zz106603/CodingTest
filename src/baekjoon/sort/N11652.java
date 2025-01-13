package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Long, Long> map = new HashMap<>();

        for(int i=0; i<n; i++){
            long token = Long.parseLong(br.readLine());
            map.put(token, map.getOrDefault(token, 0L) + 1L);
        }

        List<Map.Entry<Long, Long>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> {
            if(!e1.getValue().equals(e2.getValue())){
                return Long.compare(e2.getValue(), e1.getValue());
            }else{
                return Long.compare(e1.getKey(), e2.getKey());
            }
        });

        System.out.println(entryList.get(0).getKey());
    }
}
