package baekjoon.random;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
        코로나 바이러스로 인해 H 대학은 비대면 강의를 실시하고 있다. 조교를 담당하게 된 지환이는 출석체크 방식을 바꾸려고 한다.
        학생들은 접속 순서대로 3번부터 N + 2번까지 입장 번호를 받게 된다.
        지환이가 한 학생에게 출석 코드를 보내게 되면, 해당 학생은 본인의 입장 번호의 배수인 학생들에게 출석 코드를 보내어 해당 강의의 출석을 할 수 있게끔 한다.
        하지만, K명의 졸고 있는 학생들은 출석 코드를 제출하지 않고, 다른 학생들에게 보내지 않는다.
        지환이는 무작위로 한 명의 학생에게 출석 코드를 보내는 행위를 Q번 반복한 뒤, 출석부 정리를 위해 특정 구간의 입장 번호를 받은 학생들 중에서 출석이 되지 않은 학생들의 수를 구하고 싶다.

        학생의 수 N,
        졸고 있는 학생의 수 K,
        지환이가 출석 코드를 보낼 학생의 수 Q,
        주어질 구간의 수 M이 주어진다.
        (1 ≤ K, Q ≤ N ≤ 5,000, 1 ≤ M ≤ 50,000)

        2번째 줄과 3번째 줄에 각각 K명의 졸고 있는 학생의 입장 번호들과 Q명의 출석 코드를 받을 학생의 입장 번호들이 주어진다.
        4번째 줄부터 M개의 줄 동안 구간의 범위 S, E가 공백을 사이에 두고 주어진다. (3 ≤ S < E ≤ N + 2)

        10 1 3 1
        7
        3 5 7
        3 12
        입장 번호 3번부터 12번까지의 구간에서 입장 번호 4, 8, 11번이 출석 코드를 받지 못했고, 7번은 출석 코드를 받았으나 조느라 출석하지 못했다.

        ** 풀이 방법 **
        1. 자는 학생을 boolean[] sleep; 으로 선별한다.
        2. 출석을 부를 학생을 int[] code; 에 저장한다.
        3. for문을 배수(+=num)로 돌면서 자는 학생은 넘어가고 boolean[] attended; 에 출석한다.
        4. attended를 가지고 출석하지 않은 사람들을 계산하면되는데 접두합으로 하면 됨(3 ~ MAX+1 까지)
          4-1. pre[S] = pre[S-1] + (attended ? 0 : 1) -> 출석이 되어있지 않은 위치에서 1을 더하면 됨

         */

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int MAX = N + 2;

        // 자는 학생
        boolean[] sleep = new boolean[MAX + 1];
        boolean[] attended = new boolean[MAX + 1];

        // 자는 학생 선별
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int s = Integer.parseInt(st.nextToken());
            sleep[s] = true;
        }

        // 출석 학생 선별
        int[] code = new int[Q];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++){ code[i] = Integer.parseInt(st.nextToken()); }

        // 출석 처리
        for(int student : code){
            if(sleep[student]) continue;
            for(int j=student; j<=MAX; j += student){
                if(!sleep[j]) attended[j] = true;
            }
        }

        int[] pre = new int[MAX + 1];
        for(int i=3; i<=MAX; i++){
            pre[i] = pre[i-1] + (attended[i] ? 0 : 1);
        }

        StringBuilder sb = new StringBuilder();
        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // S 이전의 결과들은 빼줘야 구간 합이 나옴
            sb.append(pre[E] - pre[S-1]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
