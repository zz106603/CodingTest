package midas;

import java.io.*;
import java.util.*;

public class SubsetSumRemove {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) list.add(Integer.parseInt(st.nextToken()));

        int count = 0;
        boolean[] dp = new boolean[K+1];
        int[] prev = new int[K+1];

        // 반복: K를 만들 수 없을 때까지
        while (true) {
            Arrays.fill(dp, false);
            Arrays.fill(prev, -1);
            dp[0] = true;

            // 현재 남은 원소들로 K를 만들 수 있는지 DP 수행
            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i);
                for (int j = K; j >= num; j--) {
                    if (!dp[j] && dp[j - num]) {
                        dp[j] = true;
                        prev[j] = i; // j를 만들기 위해 사용된 인덱스 기록
                    }
                }
            }

            if (!dp[K]) break; // 더 이상 K를 만들 수 없으면 종료

            // K를 만드는 조합 복원
            List<Integer> used = new ArrayList<>();
            int cur = K;
            while (cur > 0) {
                int idx = prev[cur];
                if (idx == -1) break;
                used.add(idx);
                cur -= list.get(idx);
            }

            // 사용된 원소 제거 (뒤에서부터 제거)
            Collections.sort(used, Collections.reverseOrder());
            for (int idx : used) {
                list.remove(idx);
            }

            count++;
        }

        System.out.println(count);
    }
}
