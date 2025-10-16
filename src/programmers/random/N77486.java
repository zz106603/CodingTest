package programmers.random;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N77486 {

    static int[] parent;
    static int[] result;
    static Map<String, Integer> idx;
    static int N;

    public static void main(String[] args) throws IOException {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        /*
            이 문제는 연결이라고 부모-자식 문제라고 생각할 수 있지만, 계산은 자식 -> 부모로만 가므로 복잡한 trie, tree가 아님
            1. 각 이름마다 인덱스를 지정
            2. 인덱스의 부모 인덱스를 저장 (parent[])
            3. 하위에서부터 계산하면서 위로 올라가 저장
         */

        N = enroll.length;
        idx = new HashMap<>();
        for(int i=0; i<N; i++){
            idx.put(enroll[i], i);
        }

        parent = new int[N];
        Arrays.fill(parent, -1);
        result = new int[N];

        for(int i=0; i<N; i++){
            if(!referral[i].equals("-")){
                // i위치의 부모는 referral[i]
                parent[i] = idx.get(referral[i]);
            }
        }

        for(int i=0; i<seller.length; i++){
            dfs(idx.get(seller[i]), amount[i]*100);
        }

        for(int res : result){
            System.out.println(res);
        }
    }

    static void dfs(int idx, int amount){
        int give = amount/10;
        result[idx] += amount - give;
        if(parent[idx] != -1 && give > 0){
            dfs(parent[idx], give);
        }
    }
}
