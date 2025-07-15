package programmers.random;

import java.util.HashSet;
import java.util.Set;

public class N43162 {

    static Set<Integer>[] line;
    static boolean[] visit;

    public static void main(String[] args){

        int n = 5;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        line = new HashSet[n];
        visit = new boolean[n];

        int count = 0;

        for(int i=0; i<n; i++){
            line[i] = new HashSet<>();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<computers[i].length; j++){
                if(i == j) continue;

                if(computers[i][j] == 1){
                    line[i].add(j);
                    line[j].add(i);
                }
            }
        }

        for(int i=0; i<n; i++){
            if(!visit[i]){
                count++;
                dfs(i);
            }
        }
    }

    public static void dfs(int num){
        visit[num] = true;

        for(int val : line[num]){
            if(!visit[val]){
                dfs(val);
            }
        }
    }
}
