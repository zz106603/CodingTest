package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N154540 {
	
	/*
	 * 전형적인 BFS 문제
	 * X가 아닌 곳의 숫자를 더해서 총 면적 값을 구하여 리스트에 저장
	 * 리스트를 정렬하여 결과 생성
	 */

	static List<Integer> list;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visit;
	static String[][] arr;
	static int count = 0;


	public static void main(String[] args) {

		String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
		
		 arr = new String[maps.length][maps[0].length()];
	        visit = new boolean[maps.length][maps[0].length()];
	        
	        list = new ArrayList<>();
	        
	        for(int i=0; i<maps.length; i++){
	            String[] temp = maps[i].split("");
	            for(int j=0; j<temp.length; j++){
	                arr[i][j] = temp[j];
	            }
	        }
	        
	        for(int i=0; i<arr.length; i++){
	            for(int j=0; j<arr[i].length; j++){
	                if(!visit[i][j] && !arr[i][j].equals("X")){
	                    bfs(i, j);
	                    list.add(count);
	                    count = 0;
	                }
	            }
	        }
	        
	        int[] answer = new int[list.size()];
	        Collections.sort(list);
	        
	        if(list.size() == 0){
	            System.out.println(new int[]{-1});
	        }else{
	            for(int i=0; i<list.size(); i++){
	            	answer[i] = list.get(i);
	            }    
	        }
	        
	        System.out.println(list.toString());

	}
	
	 public static void bfs(int x, int y){
	        Queue<int[]> q = new LinkedList<>();
	        q.add(new int[]{x, y});
	        count += Integer.parseInt(arr[x][y]);
	        visit[x][y] = true;
	        
	        while(!q.isEmpty()){
	            int[] cur = q.poll();
	            int cx = cur[0];
	            int cy = cur[1];
	            
	            for(int k=0; k<4; k++){
	                int nx = cx + dx[k];
	                int ny = cy + dy[k];
	                
	                if(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length){
	                    if(!visit[nx][ny] && !arr[nx][ny].equals("X")){
	                        q.add(new int[]{nx, ny});
	                        visit[nx][ny] = true;
	                        count += Integer.parseInt(arr[nx][ny]);
	                    }
	                }
	            }
	        }
	    }

}
