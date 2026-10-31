package tocsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class two {

    static int res = 0;
    static int N, K, P;
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        arr = new int[N][K];
        visit = new boolean[N][K];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


//        for(int i=0; i<N; i++){
//            dfs()
//        }

        dfs(0, 0, new ArrayList<>());

    }


    static int c = 0;
    public static void dfs(int count, int total, List<Integer> tmp){

//        System.out.println(tmp);
        if(count == P){
            res = Math.max(res, total);
            System.out.println(tmp);
            return;
        }

        for(int i=0; i<N; i++){
                for(int j=0; j<K; j++){
                    if(!visit[i][j]){
                        visit[i][j] = true;
                        tmp.add(arr[i][j]);
                        dfs(count+1, total+arr[i][j], tmp);
                        tmp.remove(tmp.size()-1);

                        if(c == 0){
                            System.out.println(i + ", " + j + ", " + arr[i][j]);
                            c++;
                        }

                        visit[i][j] = false;
                    }
                }
        }

    }
}


/*

N개의 상자에 K개씩 쌓여있고 가치가 있음 (객체로 표현?)

상자에서는 위에있는 물건부터 순서대로. (stack?)

3번째를 꺼내려면 1, 2번도 함께 꺼내야함 그러면 stack으로 3까지 반복해서 꺼낸다

상자에서 몇개를 꺼낼지는 자유

P개의 물건을 꺼냈을 때 가치 합이 최대가 되도록 해야 함

 */