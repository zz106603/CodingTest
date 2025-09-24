package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6987 {
    static final int TEAM = 6;
    static final int MATCHES = 15;

    static int[] W = new int[TEAM];
    static int[] D = new int[TEAM];
    static int[] L = new int[TEAM];

    static int[][] match = new int[MATCHES][2];
    static boolean ok;

    static{
        // 6C2 = 15경기 미리 나열
        int idx = 0;
        for(int i=0; i<TEAM; i++){
            for(int j=i+1; j<TEAM; j++){
                match[idx][0] = i;
                match[idx][1] = j;
                idx++;
            }
        }
    }

    /*
        3팀이라고 했을 때, 아래와 같이 미리 대전을 만들어 놓는다.
        (0, 1), (0, 2), (0, 3), (1, 2), (1, 3), (2, 3)

        백 트래킹을 하기 전에 선제적으로 검사할 수 있는 부분은 검사한다.
        1. W + D + L의 합이 3경기가 아니면 불가능
        2. W의 합과, L의 합이 다르면 불가능
        3. D의 값이 홀수면 불가능

        위 경기들을 3가지 경우의 수로 백트래킹으로 가능한지 확인한다.
        (a, b)라고 했을 때, 둘 다 0보다 커야 가능하다.
        1. a 승, b 패
        - if(W[a] > 0 %% L[b] > 0)
        - W[a]--; L[b]--;
        - dfs(idx+1);
        - W[a]++; L[b]++;
        2. a 무, b 무
        3. a 패, b 승
        결과적으로, 15경기를 모두 완료할 수 있으면 1이다.

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        for(int tc=0; tc<4; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sumW = 0, sumD = 0, sumL = 0;
            boolean quickFail = false;

            for(int i=0; i<TEAM; i++){
                W[i] = Integer.parseInt(st.nextToken());
                D[i] = Integer.parseInt(st.nextToken());
                L[i] = Integer.parseInt(st.nextToken());

                // 팀 당 5경기 체크
                if(W[i] + D[i] + L[i] != 5) quickFail = true;

                sumW += W[i];
                sumD += D[i];
                sumL += L[i];
            }

            // 빠른 컷 (5경기를 하지 않았거나, 이긴 총합과 진 총합이 다르다거나, 무승부가 홀수라서 맞지 않을 때)
            if(quickFail || sumW != sumL || (sumD%2 != 0)){
                out.append("0 ");
                continue;
            }

            ok = false;
            dfs(0);

            out.append(ok ? "1 " : "0 ");
        }

        System.out.println(out.toString());
    }

    static void dfs(int idx){
        if(ok) return;
        if(idx == MATCHES){
            ok = true;
            return;
        }

        int a = match[idx][0];
        int b = match[idx][1];

        // a 승, b 패
        if(W[a] > 0 && L[b] > 0){
            W[a]--; L[b]--;
            dfs(idx+1);
            W[a]++; L[b]++;
        }

        // a 무, b 무
        if(D[a] > 0 && D[b] > 0){
            D[a]--; D[b]--;
            dfs(idx+1);
            D[a]++; D[b]++;
        }

        // a 패, b 승
        if(L[a] > 0  && W[b] > 0){
            L[a]--; W[b]--;
            dfs(idx+1);
            L[a]++; W[b]++;
        }
    }
}
