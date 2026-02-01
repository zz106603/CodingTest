package musinsa.chatgpt;

import java.io.*;
import java.util.*;

public class Exam12 {
    static class Log{
        String productId;
        int count;
        Set<String> userArray = new HashSet<>();
        Log(String productId){
            this.productId = productId;
            this.count = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*

         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, Log> map = new HashMap<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String uid = st.nextToken();
            String pid = st.nextToken();

            Log log = map.computeIfAbsent(pid, Log::new);
            log.count++;
            log.userArray.add(uid);
        }

        List<Log> list = new ArrayList<>(map.values());
        list.sort((a, b) ->{
            int c1 = Integer.compare(b.count, a.count);
            if(c1 != 0) return c1;
            int c2 = Integer.compare(b.userArray.size(), a.userArray.size());
            if(c2 != 0) return c2;
            return a.productId.compareTo(b.productId);
        });

        K = Math.min(K, list.size());
        for(int i=0; i<K; i++){
            Log log = list.get(i);
            bw.write(log.productId + " " + log.count + " " + log.userArray.size() + "\n");
        }
        bw.close();

    }
}
