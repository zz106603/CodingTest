package programmers.random;

import java.util.HashSet;
import java.util.Set;

public class N42862 {
    public static void main(String[] args){
        int n = 5;
        int[] lost = new int[]{2, 4};
        int[] reserve = new int[]{1, 3, 5};

        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for(int val : lost) lostSet.add(val);
        for(int val : reserve) reserveSet.add(val);

        // 1. 체육복을 2개 가져온 사람 즉, 중복은 미리 제거한다. (본인한테 빌리면 됨)
        for(int i=1; i<=n; i++){
            if(lostSet.contains(i) && reserveSet.contains(i)){
                lostSet.remove(i);
                reserveSet.remove(i);
            }
        }

        // 2. 빌려야 하는 사람이 있으면 i-1, i+1 순서대로 확인하고 빌릴 수 있으면 빌려준 사람 remove, 빌림 받은 사람 remove
        // 이 때 빌려준 사람은 i-1이나 i+1이 되고 빌림받은 사람은 i임
        for(int i=1; i<=n; i++){
            if(lostSet.contains(i)){
                if(reserveSet.contains(i-1)){
                    reserveSet.remove(i-1);
                    lostSet.remove(i);
                }else if(reserveSet.contains(i+1)){
                    reserveSet.remove(i+1);
                    lostSet.remove(i);
                }
            }
        }

        System.out.println(n - lostSet.size());
    }
}
