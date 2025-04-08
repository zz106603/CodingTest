package baekjoon.random;

import java.io.*;

public class N20125 {
    /*
__________
_____*____
__******__
_____*____
_____*____
_____*____
____*_*___
____*_____
____*_____
____*_____

심장 좌표 기준(3,6)
- x가 같고 y가 왼쪽이면 왼팔
- x가 같고 y가 오른쪽이면 오른팔
- y가 같으면 몸통
- y-1이 *면 왼다리
- y+1이 *면 오른다리
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N+1][N+1];

        for(int i=1; i<=N; i++){
            String[] line = br.readLine().split("");
            for(int j=1; j<=N; j++){
                arr[i][j] = line[j-1];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean headFlag = false;
        int heartX = 0;
        int heartY = 0;

        int leftArm = 0;
        int rightArm = 0;
        int center = 0;
        int leftFoot = 0;
        int rightFoot = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(arr[i][j].equals("*")){
                    if(headFlag != true){
                        heartX = i+1;
                        heartY = j;
                        bw.write(heartX + " " + heartY + "\n");
                        headFlag = true;
                    }else{
                        if(i == heartX){
                            if(j < heartY){
                                leftArm++;
                            }else if(j > heartY){
                                rightArm++;
                            }
                        }else if(j == heartY){
                            center++;
                        }else{
                            if(j == heartY-1){
                                leftFoot++;
                            }else if(j == heartY+1){
                                rightFoot++;
                            }
                        }
                    }
                }
            }
        }

        bw.write(leftArm + " " + rightArm + " " + center + " " + leftFoot + " " + rightFoot);
        bw.flush();
        bw.close();

    }
}
