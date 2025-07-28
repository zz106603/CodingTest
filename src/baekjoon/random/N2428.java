package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        /*
        (Fi, Fj) 쌍을 검사해야 하는데, 이때,
        1. i≠j이고, -> 순서 쌍을 찾는 문제구나
        2. size(Fi) ≤ size(Fj)이면서, -> 정렬을 하면 편하겠구나
        3. size(Fi) ≥ 0.9 × size(Fj)인 쌍만 검사 -> 특정 조건부 검사니까 투포인터 사용해야겠다

        5
        1 1 1 1 1
         */

        long answer = 0;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        /*
            size(Fi) ≥ 0.9 × size(Fj)
            이 조건을 만족할때 까지 정렬된 배열에서 시작 index를 찾는다(left)
            조건이 만족하면 자연스럽게 그 뒤의 인덱스도 쌍이 된다.
            ex) left = 2, right = 4 -> (2, 4), (3, 4) 총 2개가 쌍이 가능함
            따라서 right - left를 answer에 더해주면 값이 나옴
        */
        int left = 0;
        for(int right=0; right<N; right++){
            while(arr[left] < 0.9*arr[right]){
                left++;
            }
            answer += right - left;
        }

        System.out.println(answer);
    }
}
