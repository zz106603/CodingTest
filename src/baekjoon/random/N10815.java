package baekjoon.random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());

            boolean res = binarySearch(arr, num);

            if(res) bw.write("1 ");
            else bw.write("0 ");

        }

        bw.flush();
        bw.close();
    }

    public static boolean binarySearch(int[] arr, int num){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] == num){
                return true;
            }else if(arr[mid] < num){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
