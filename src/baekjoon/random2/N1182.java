package baekjoon.random2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N1182 {
    static int answer = 0;
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        for(int i=0; i<N; i++){
//            dfs(i, arr[i]);
//        }

        dfs(0, 0);

        // 공집합 제외
        // dfs 메서드에서 원소를 선택하지 않고 idx==N까지 오게되면 S가 0일 경우, answer가 증가될 수 있음
        // []은 제외해야 함
        if(S == 0){
            answer--;
        }

        System.out.println(answer);
    }

    public static void dfs(int idx, int sum){
        if(idx == N){
            if(sum == S){
                answer++;
            }
            return;
        }

        // 원소를 선택
        dfs(idx+1, sum + arr[idx]);

        // 원소를 선택하지 않음
        dfs(idx+1, sum);
    }

//    public static void dfs(int start, int sum){
//        if(sum == S){ // 이미 값이 나와도, 뒤에 0이 나오면 그것도 조합이 되므로 return하면 안 됨
//            answer++;
//        }
//
//        for(int i=start+1; i<N; i++){
//            sum += arr[i];
//            dfs(i, sum);
//            sum -= arr[i];
//        }
//    }
}
