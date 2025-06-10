package programmers.random;


import java.util.LinkedList;
import java.util.Queue;

public class N389479 {
    public static void main(String[] args) {

        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;

        Queue<int[]> qu = new LinkedList<>();

        int server = 0;
        int answer = 0;

        for(int i=0; i<24; i++){
            while(!qu.isEmpty() && qu.peek()[0] == i){
                server -= qu.poll()[1];
            }

            int need = players[i]/m;
            int more = server - need;
            if(more < 0){
                more = -more;
                answer += more;
                server += more;
                qu.add(new int[]{i+k, more});
            }
        }

        System.out.println(answer);
    }
}
