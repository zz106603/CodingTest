package musinsa.chatgpt.sort;

import java.io.*;
import java.util.*;

public class Exam1 {
    static class Product{
        String productId;
        int score;
        int reviewCount;
        Product(String productId, int score, int reviewCount){
            this.productId = productId;
            this.score = score;
            this.reviewCount = reviewCount;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            상품 N
            productId, score, reviewCount

            1. score 내림차순
            2. reviewCount 내림차순
            3. productId 오름차순(사전순)

            상위 K개 출력
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Product[] arr = new Product[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String productId = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            int reviewCount = Integer.parseInt(st.nextToken());

            Product p = new Product(productId, score, reviewCount);
            arr[i] = p;
        }

        Arrays.sort(arr, (a, b) ->{
            int c1 = Integer.compare(b.score, a.score);
            if(c1 != 0) return c1;
            int c2 = Integer.compare(b.reviewCount, a.reviewCount);
            if(c2 != 0) return c2;
            return a.productId.compareTo(b.productId);
        });

        for(int i=0; i<K; i++){
            bw.write(arr[i].productId + "\n");
        }

        bw.flush();
        bw.close();

    }
}
