package programmers.level2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N17683 {
	
	/*
	 * 1. C#, B#과 같은 코드들을 c, b와 같이 한 문자로 치환하는 것이 중요
	 * 2. HH와 MM으로 구분해서 분 차이를 구하는 것이 중요
	 * 3. 코드를 time에 맞추어서 늘릴 수 있는 것이 중요(나머지 연산과 charAt을 사용)
	 * 4. 노래가 여러개에 포함되어 있을 경우, time이 긴 것, time이 같을 경우 먼저 나온 것을 판단하는 조건문 중요
	 */

	public static void main(String[] args) {
		
		
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		String m = "ABC";
		
		String answer = "";
		
		m = replaceNode(m);
		
		int min = 0;
		
		for(String str : musicinfos) {
			String[] temp = str.split(",");
			
			int start = Integer.parseInt(temp[0].split(":")[0])*60 + Integer.parseInt(temp[0].split(":")[1]);
			int end = Integer.parseInt(temp[1].split(":")[0])*60 + Integer.parseInt(temp[1].split(":")[1]);
			int time = end - start;
			
			String music = temp[2];
			
			String code = replaceNode(temp[3]);
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<time; i++) {
				sb.append(code.charAt(i % code.length()));
			}
			code = sb.toString();
			
			if(code.contains(m)) {
				if(time > min) {
					min = time;
					answer = music;
				}
			}
		}
		
		System.out.println(answer);
		

	}
	
	public static String replaceNode(String m) {
		return m.replaceAll("C#", "c")
				.replaceAll("D#", "d")
				.replaceAll("F#", "f")
				.replaceAll("G#", "g")
				.replaceAll("A#", "a")
				.replaceAll("B#", "b");
	}

}
