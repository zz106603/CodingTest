package musinsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        정수 배열 arr
        1. 배열에서 짝수만 남김
        2. 남은 수 중에서 10이상 100미만인 값만 유지
        3. 각 숫자를 문자열로 변환했을 때, 일의 자리 숫자가 3또는 7로 끝나는 값은 제거
        4. 남은 수들을 오른차순 정렬
        5. 결과를 공백으로 구분하여 한 줄로 출력
        결과가 비어있으면 EMPTY
         */

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            if(arr[i] % 2 == 0 && (arr[i] >= 10 && arr[i] < 100)){
                int last = arr[i] % 10;
                if(last != 3 && last != 7){
                    list.add(arr[i]);
                }
            }
        }

        Collections.sort(list);

        if(list.isEmpty()){
            System.out.println("EMPTY");
        }else{
            for(int l : list){
                System.out.print(l + " ");
            }
        }

        /*
            V2(Stream)
         */
        List<Integer> list2 = Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .filter(x -> x >= 10 && x < 100)
                .filter(x -> {
                    int last = x % 10;
                    return last != 3 && last != 7;
                })
                .sorted()
                .boxed()
                .toList();

        for(int l : list2){
            System.out.print(l + " ");
        }
    }
}
