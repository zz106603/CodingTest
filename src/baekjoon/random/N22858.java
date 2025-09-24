package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N22858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] D = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){ arr[i] = Integer.parseInt(st.nextToken()); }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){ D[i] = Integer.parseInt(st.nextToken()); }

        int[] res = new int[N];
        for(int i=0; i<K; i++){
            for(int j=0; j<N; j++){
                int idx = D[j]-1;
                res[idx] = arr[j];
            }
            // arr = res는 같은 배열을 바라보므로 값이 둘 다 바뀌는 상황이 생길 수 있음
            // clone이나 swap을 활용하면 복사, 참조를 이용하기 때문에 각자 배열을 따로 관리 가능
            // arr = res.clone();
            int[] tmp = arr;
            arr = res;
            res = tmp;
        }

        for(int n : arr){
            System.out.print(n + " ");
        }
    }
}
