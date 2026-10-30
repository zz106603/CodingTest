package tocsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class one {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Queue<Integer> qu = new LinkedList<>();
        Queue<Integer> tmp = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            qu.add(Integer.parseInt(st.nextToken()));
        }

        int totalPrice = 0;

        while(R > 0){
            R -= 1;
            int curCount = 0;

            while(!qu.isEmpty()){

                int first = qu.peek();

                if(curCount + first <= K){
                    int cur = qu.poll();
                    totalPrice += cur;
                    tmp.add(cur);
                    curCount += first;
                }else{
                    break;
                }
            }

            while(!tmp.isEmpty()){
                qu.add(tmp.poll());
            }
        }

        System.out.println(totalPrice);
    }
}


/*

셔틀버스

일행은 함께 버스에 탑승
최대 K명 탑승 가능

일행이 탑승할 수 없으면 운행 시작

탑승자들은 맨 뒤로 이동 (Queue?)
한 명당 1유로

R번 운행

 */