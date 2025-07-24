package baekjoon.random;

import java.io.*;
import java.util.*;

public class N1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
            A = { 1, 2, 4 } 이고,
            B = { 2, 3, 4, 5, 6 } 라고 할 때,

            1 2 2 3 4 4 5 6

            A-B = { 1 } 이고,
            B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.
         */

        int aLen = Integer.parseInt(st.nextToken());
        int bLen = Integer.parseInt(st.nextToken());

//        List<Integer> totalList = new ArrayList<>();
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<aLen; i++){
//            totalList.add(Integer.parseInt(st.nextToken()));
//        }
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<bLen; i++){
//            totalList.add(Integer.parseInt(st.nextToken()));
//        }
//
//        Collections.sort(totalList);
//
//        int curr = 0;
//        int same = 0;
//        for(int num : totalList){
//            if(num == curr){
//                answer--;
//                continue;
//            }
//
//            answer++;
//            curr = num;
//        }
//
//        System.out.println(answer);


    /*
        위 방법도 가능은 하지만 시간복잡도나 가독성이 안좋음
        Set을 사용해서 구하는게 가장 좋은 방법
     */

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<aLen; i++){
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<bLen; i++){
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> intersection = new HashSet<>(aSet);
        intersection.retainAll(bSet);

        // 두 집합의 전체 사이즈에서 교집합을 빼야하는데, a, b 둘 다 빼줘야하기 때문에 *2
        System.out.println(aSet.size() + bSet.size() - 2 * intersection.size());
    }
}
