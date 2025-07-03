package programmers.random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N42839 {
    public static void main(String[] args) {

        String numbers = "17";
        int result = 3;

        int answer = 0;

        // 1. 완성된 순열을 넣을 리스트 필요 -> 중복은 제거하기 위해 Set 사용
        Set<Integer> permutations = new HashSet<>();
        // 2. 이미 사용된 문자인지 검증
        boolean[] visit = new boolean[numbers.length()];

        permutation(numbers, "", visit, permutations);

        System.out.println("순열 결과: ");
        for(int num : permutations){
            if(isPrime(num)){
                answer++;
            }
            System.out.println(num);
        }

        List<List<Integer>> combinations = new ArrayList<>();
        combination(numbers, new ArrayList<>(), 0, combinations);
        System.out.println("조합 결과: ");
        for(List<Integer> com : combinations){
            System.out.println(com);
        }


//        System.out.println(answer);
    }

    // 순열
    public static void permutation(String numbers, String current, boolean[] visit, Set<Integer> permutations){
        if(!current.isEmpty()){
            permutations.add(Integer.parseInt(current));
            // 현재는 r이 정해져있지 않고 모든 경우의 수 이기 때문에 return이 없어야 함.
        }

        for(int i=0; i<numbers.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                permutation(numbers, current + numbers.charAt(i), visit, permutations);
                visit[i] = false;
            }
        }
    }

    // 조합 (연습)
    public static void combination(String numbers, List<Integer> current, int start, List<List<Integer>> combinations){
        if(!current.isEmpty()){
            combinations.add(new ArrayList<>(current));
            // 현재는 r이 정해져있지 않고 모든 경우의 수 이기 때문에 return이 없어야 함.
        }

        for(int i=start; i<numbers.length(); i++){
            current.add(numbers.charAt(i) - '0');
            combination(numbers, current, i + 1, combinations);
            current.remove(current.size() - 1);
        }
    }

    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}
