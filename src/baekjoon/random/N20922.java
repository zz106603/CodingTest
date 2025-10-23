package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
            같은 원소가 K개 이하로 들어 있는 최장 연속 부분 수열의 길이
            조건을 넘어서면 left를 ++ 조건이 만족하면 right를 ++
            map으로 숫자에 대한 나온 개수를 ++하거나 --하면서 ? 그럼 map이 아니고 배열로도 가능할듯
         */
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] count = new int[100001];

        int left = 1;
        int right = 1;
        while(right <= N){
            if(count[arr[right]] < K){ // right를 옮겨주기 때문에, K 미만으로 잡아야 검사 가능
                count[arr[right]]++;
                right++;
                answer = Math.max(answer, (right-left));
            }else{
                count[arr[left]]--;
                left++;
            }
        }

        System.out.println(answer);
    }
}

/*
10 1
1 2 3 4 5 6 6 7 8 9

left: 1, right: 1
arr[1]++;
arr[1]이 K보다 작거나 같음 -> 통과
right++;

left: 1, right: 2
arr[2]++;
arr[1], arr[2]가 K보다 작거나 같음 -> 통과
right++;

..

left: 1, right: 6
arr[6]++; 현재 값 1
arr[1~6]이 K보다 작거나 같음 -> 통과
right++;

left: 1, right: 6

 */