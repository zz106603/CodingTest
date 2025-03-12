package baekjoon.random;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N10431 {
    public static void main(String[] args) throws IOException {
        /*
        1 2 3 4 5 6 7 8 ..

        1. 아무나 뽑아서 맨 앞에 세운다
         자기 앞에 자기보다 키 큰 학생이 없으면 그냥 그 자리 대기
         자기 앞에 자기보다 키 큰 학생이 있으면 그 중 가장 앞에 있는 학생(A)의 바로 앞에 선다. 이 때 A부터 뒤로 한 발씩 물러난다

1
1 919 918 917 916 915 914 913 912 911 910 909 908 907 906 905 904 903 902 901 900

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> result = new LinkedHashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int count = 0;
            int[] arr = new int[20];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            result.put(key, 0);
            for(int j=0; j<20; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=1; j<20; j++){
                for(int k=0; k<j; k++){
                    if(arr[k] > arr[j]){
                        count++;
                    }
                }
            }
            result.put(key, result.getOrDefault(result.get(key), 0) + count);
        }

        for(Map.Entry<Integer, Integer> entry : result.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }   
}
