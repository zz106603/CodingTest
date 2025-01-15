package programmers.stackAndQueue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class N42584 {

    public static void main(String[] args) throws IOException {
    }

    public int[] solution(int[] prices) {

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<prices.length; i++){
            int val = prices[i];
            int count = 0;
            for(int j=i+1; j<prices.length; j++){
                if(prices[j] < val){
                    count++;
                    break;
                }else{
                    count++;
                }
            }
            list.add(count);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
