package programmers.random;

import java.util.Map;
import java.util.Set;

public class N67256 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        StringBuilder sb = new StringBuilder();

        Set<Integer> leftSet = Set.of(1, 4, 7);
        Set<Integer> rightSet = Set.of(3, 6, 9);

        /*
            가까운 거리를 찾기 위해서는 번호의 좌표를 이용
            x축과 차이, y축과 차이를 더하면 가까운 거리를 구할 수 있음
            시작 위치는 마찬가지로 좌표로 지정 (*, #)
         */
        Map<Integer, int[]> position = Map.of(
                1, new int[]{0, 0},
                2, new int[]{0, 1},
                3, new int[]{0, 2},
                4, new int[]{1, 0},
                5, new int[]{1, 1},
                6, new int[]{1, 2},
                7, new int[]{2, 0},
                8, new int[]{2, 1},
                9, new int[]{2, 2},
                0, new int[]{3, 1}
        );

        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};

        for(int num : numbers){
            if(leftSet.contains(num)){
                sb.append("L");
                left = position.get(num).clone();
            }else if(rightSet.contains(num)){
                sb.append("R");
                right = position.get(num).clone();
            }else{
                int[] target = position.get(num);
                int leftDist = Math.abs(target[0] - left[0]) + Math.abs(target[1] - left[1]);
                int rightDist = Math.abs(target[0] - right[0]) + Math.abs(target[1] - right[1]);

                if(leftDist < rightDist){
                    sb.append("L");
                    left = target.clone();
                }else if(rightDist < leftDist){
                    sb.append("R");
                    right = target.clone();
                }else{
                    if(hand.equals("left")){
                        sb.append("L");
                        left = target.clone();
                    }else{
                        sb.append("R");
                        right = target.clone();
                    }
                }
            }
        }

        System.out.println(sb.toString().equals("LRLLLRLLRRL"));

    }
}
