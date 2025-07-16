package baekjoon.random;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class N11502 {

    static List<Integer> primeList;
    static List<Integer> subList;
    static boolean flag;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        /*

        ** 처음 생각했던 방법
        1. 25보다 작은 소수들을 찾는다
        2. 소수들을 3개 더했을 때, 25라는 값이 나오는지 DFS를 통해서 검증
        3. 3개 더한 값이 K값과 같으면 그 값을 그대로 저장(낮은 값부터 시작하기 때문에 오름차순 따로 처리 필요 없음)

        ** 개선 방법
        1. 소수를 반복문마다 구하지 말고, 범위가 < 1000이라서 미리 구해놓는 방법
        2. DFS에서 중복 조합이 나오는 경우를 대비해 startIdx를 통해 중복 제거
         */

        primeList = new ArrayList<>();
        for(int i=2; i<1000; i++){
            if(isPrime(i)){
                primeList.add(i);
            }
        }

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

//            .toList()는 Java 16부터 등장
//            subList = primeList.stream().filter(p -> p < K).toList();
//            하지만, 이 경우에는 수정 불가능
            subList = primeList.stream()
                    .filter(p -> p < K)
                    .collect(Collectors.toList());

            flag = false;
            sb = new StringBuilder();

            dfs(0, new ArrayList<>(),0, K, 0);

            if(!flag){
                bw.write("0\n");
            }else{
                bw.write(sb.toString());
            }
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int sum, List<Integer> ansList, int count, int K, int start){
        if(flag) return;

        if(count == 3){
            if(sum == K){
                flag = true;
                for(int num : ansList){
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=start; i<subList.size(); i++){
            ansList.add(subList.get(i));
            dfs(sum + subList.get(i), ansList, count + 1, K, i);
            ansList.remove(ansList.size()-1);
        }
    }

    static public boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
