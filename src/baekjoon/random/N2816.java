package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> channel = new ArrayList<>();
        for(int i=0; i<n; i++){
            channel.add(br.readLine());
        }

        int kbs1 = 0;
        int kbs2 = 0;
        for(int i=0; i<n; i++){
            if(channel.get(i).equals("KBS1")){
                kbs1 =  i;
            }else if(channel.get(i).equals("KBS2")){
                kbs2 = i;
            }
        }

        /*
            MBC
            KBS1
            KBS2

            이렇게 있을 경우에 KBS2가 위로 올라오면서 KBS1이 한 칸 뒤로 밀림
            KBS1은 첫 번째로 가야하기 때문에 kbs1++을 통해 반복 횟수 하나 증가
         */
        if(kbs2 > kbs1){
            kbs1++;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("1".repeat(kbs2));
        sb.append("4".repeat(kbs2));
        sb.append("1".repeat(kbs1));
        sb.append("4".repeat(kbs1));

        System.out.println(sb.toString());

    }
}
