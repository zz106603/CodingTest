package baekjoon.random;

import java.io.*;
import java.util.*;

public class N15656 {
    static int N, M;
    static int[] arr, pick;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
        List.add를 통해 만들어진 List를 출력하는 방법도 있지만,
        1차원 배열을 이용해서 값을 넣는게 시간적으로 더 빠름
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        pick = new int[M];

        dfs(new ArrayList<>());
//        dfs(0);

//        bw.write(sb.toString());
        bw.flush();
    }

//    static void dfs(int depth) throws IOException{
//        if(depth == M){
//            for(int i=0; i<M; i++){
//                if(i > 0) sb.append(' ');
//                sb.append(pick[i]);
//            }
//            sb.append('\n');
//            return;
//        }
//
//        for(int i=0; i<N; i++){
//            pick[depth] = arr[i];
//            dfs(depth + 1);
//        }
//    }

    static void dfs(List<Integer> list) throws IOException{
        if(list.size() == M){
            for(int num : list){
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0; i<N; i++){
            list.add(arr[i]);
            dfs(list);
            list.remove(list.size()-1);
        }
    }
}
