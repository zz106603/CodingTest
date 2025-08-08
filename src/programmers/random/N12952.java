package programmers.random;

public class N12952 {

    /*
        문제의 키 포인트
        1. 한 row에는 한 개의 퀸만 자리잡을 수 있다. (좌, 우는 검사 할 필요가 없음)
        2. row를 기준으로 한 row씩 증가시키며 퀸 위치가 가능한 col을 찾는다.
        3. 상, 하, 대각선에 퀸이 있는지만 판단하면 됨
            - 상, 하는 열 이므로 col[]로 관리
            - 우상, 좌상 대각선은 row+col이 같은 값이므로 diag1[]로 관리
            - 좌상, 우하 대각선은 row-col+N-1이 같은 값이므로 diag2[]로 관리
        4. 백트래킹을 통해 불가능하면 이 전으로 돌아가서 검사하는 방식으로 진행

     */
    static boolean col[]; // 퀸은 같은 열에 있을 수 없음
    static boolean diag1[]; // 퀸은 우상, 좌하 대각선에 있을 수 없음 (row + col)
    static boolean diag2[]; // 퀸은 좌상, 우하 대각선에 있을 수 없음 (row - col + N - 1)
    static int N = 4;
    static int RESULT = 2;
    static int answer = 0;
    public static void main(String[] args){
        col = new boolean[N];
        // row+col, row-1을 충분히 넣으려면 필요 ex)N=4 row+col의 최대값은 3+3=6, 2*N-1 = 7이므로 배열 크기가 맞음
        diag1 = new boolean[2*N-1];
        diag2 = new boolean[2*N-1];

        dfs(0);
    }

    public static void dfs(int row){
        if(row == N){
            answer++;
            return;
        }
        for(int c=0; c<N; c++){
            if(col[c] || diag1[row + c] || diag2[row - c + N - 1]) continue; // 퀸이 공격 가능한 범위이기 때문에 불가능
            col[c] = true;
            diag1[row + c] = true;
            diag2[row - c + N - 1] = true;

            dfs(row+1);

            col[c] = false;
            diag1[row + c] = false;
            diag2[row - c + N - 1] = false;
        }
    }


}
