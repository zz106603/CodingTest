package programmers.random;

import java.util.LinkedList;
import java.util.Queue;

public class N43165 {
    static int answer2 = 0;
    public static void main(String[] args){
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = dfs(numbers, target, 0, 0);
        System.out.println(answer);

        bfs(numbers, target);
        System.out.println(answer2);
    }

    public static int dfs(int[] numbers, int target, int sum, int idx){
        if(numbers.length == idx){
            return sum == target ? 1 : 0;
        }

        int plus = dfs(numbers, target, sum + numbers[idx], idx + 1);
        int minus = dfs(numbers, target, sum - numbers[idx], idx + 1);
        return plus + minus;
    }

    public static void bfs(int[] numbers, int target){
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{0, 0}); // sum, idx

        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int sum = cur[0];
            int idx = cur[1];

            if(idx == numbers.length){
                if(sum == target){
                    answer2++;
                }
            }else{
                qu.add(new int[]{sum + numbers[idx], idx + 1});
                qu.add(new int[]{sum - numbers[idx], idx + 1});
            }
        }
    }
}
