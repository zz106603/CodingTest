package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N8979 {
    public static void main(String[] args) throws IOException {
        /*
            4 3
            1 1 2 0
            2 0 1 0
            3 0 1 0
            4 0 0 1
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int resultCountry = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][4];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[1] != b[1]) return Integer.compare(b[1], a[1]);
            if(a[2] != b[2]) return Integer.compare(b[2], a[2]);
            return Integer.compare(b[3], a[3]);
        });

        int rank = 1;
        int resultRank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                if (arr[i][1] != arr[i - 1][1] || arr[i][2] != arr[i - 1][2] || arr[i][3] != arr[i - 1][3]) {
                    /*
                        여기서 중요한 포인트
                        rank = rank + 1로 하게 되면, 1등, 2등, 2등 다음에 3등이 나옴
                        rank = i + 1로 해야, 1등, 2등, 2등, 4등이 제대로 나옴
                     */
                    rank = i + 1;
                }
            }
            if (arr[i][0] == resultCountry) {
                resultRank = rank;
                break;
            }
        }

        System.out.println(resultRank);
    }
}
