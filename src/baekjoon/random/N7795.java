package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        8 1 7 3 1
        3 6 1

        투 포인터 방법을 사용하는게 시간 복잡도에 좋음
        1. 두 배열이 있고, 정렬하면 순차적으로 비교 가능하다.
        2. 한 쪽 포인터가 한 번 이동하면 다시 뒤로 갈 필요가 없다.
        3. 따라서 한 번의 선형 스캔으로 각 A에 대해 B에서 작은 원소 개수를 누적할 수 있다.


        1. 2개의 배열을 오름차순 정렬
        2. A가 B보다 크면 쌍이 가능하다는 뜻, 쌍이 가능하면 j++를 통해 다음 포인터로 이동
        3. count += j는 이전의 가능한 쌍의 개수 + 1이므로, 결과값을 재사용 가능
        ex) A에서 7까지 왔을때 이미 j는 1, 3을 거쳐서 2의 값임 거기에 6이 가능하니까 + 1해서 3을 결과에 누적하면 됨

        1 1 3 7 8
        1 3 6
         */
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int k=0; k<T; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int size2 = Integer.parseInt(st.nextToken());

            int[] arr = new int[size];
            int[] arr2 = new int[size2];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<size; i++){ arr[i] = Integer.parseInt(st.nextToken()); }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<size2; i++){ arr2[i] = Integer.parseInt(st.nextToken()); }

            Arrays.sort(arr);
            Arrays.sort(arr2);

            int count = 0;
            int j = 0;
            for(int i=0; i<size; i++){
                while(j < size2 && arr2[j] < arr[i]){
                    j++;
                }
                count += j;
            }

            sb.append(count + "\n");
        }

        System.out.print(sb.toString());
    }
}
