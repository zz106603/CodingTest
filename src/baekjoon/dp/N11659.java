package baekjoon.dp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N11659 {
    /*
        각 index에 이전 값 + 현재 값
        arr[end] - arr[start-1]로 부분합을 구할 수 있음

        포인트는 부분합을 전부 구해놓고 end에서 start-1의 값을 빼는 것을 생각해내는 것 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] sumArr = new int[n+1];
        List<Integer> result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(i == 1){
                sumArr[1] = num;
            }else{
                sumArr[i] = sumArr[i-1] + num;
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            result.add(sumArr[end] - sumArr[start-1]);
        }

        for(Integer val : result){
            bw.write(val+"\n");
        }
        bw.flush();
        bw.close();
    }
}
