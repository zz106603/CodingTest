package softeer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N411946 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

/*
3
1.2
1.11
2.9
4.2
3
 */
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for(int i=0; i<n; i++){
			String input = br.readLine();
			list.add(input);
		}

		Collections.sort(list, (a, b) -> {
			boolean aInteger = !a.contains(".");
			boolean bInteger = !b.contains(".");

			int leftA = Integer.parseInt(a.split("\\.")[0]);
			int leftB = Integer.parseInt(b.split("\\.")[0]);
			if(leftA != leftB) return Integer.compare(leftA, leftB);

			if(aInteger && !bInteger) return -1;
			if(!aInteger && bInteger) return 1;

			if(!aInteger && !bInteger){
				int rightA = Integer.parseInt(a.split("\\.")[1]);
				int rightB = Integer.parseInt(b.split("\\.")[1]);
				if(rightA != rightB) return Integer.compare(rightA, rightB);
			}

			return 0;
		});

		for(String res : list){
			bw.write(res + "\n");
		}
		bw.flush();
		bw.close();

	}
}
