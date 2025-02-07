package softeer;

import java.io.*;
import java.util.*;

public class N411222 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
/*
3
1 3
2 4
3 5
 */
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (a, b) -> {
			if(a[1] != b[1]){
				return Integer.compare(a[1], b[1]);
			}
			return Integer.compare(a[0], b[0]);
		});

		int count = 0;
		int endTime = 0;

		for(int[] time : arr){
			if(time[0] >= endTime){
				count++;
				endTime = time[1];
			}
		}

		System.out.println(count);

	}
}
