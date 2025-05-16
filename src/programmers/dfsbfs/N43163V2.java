package programmers.dfsbfs;

import java.io.IOException;
import java.util.*;


public class N43163V2 {

	public static class Node{
		String word;
		int count;

		public Node(String word, int count){
			this.word = word;
			this.count = count;
		}
	}

	static Set<String> visit;
	public static void main(String[] args) throws IOException{
		String begin = "hit";
		String target = "cog";
		String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};

		visit = new HashSet<>();
		int result = bfs(begin, target, words);

		System.out.println(result);
	}

	public static int bfs(String begin, String target, String[] words){
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(begin, 0));

		while(!qu.isEmpty()){
			Node node = qu.poll();
			String word = node.word;
			int count = node.count;

			if(target.equals(word)) return count;

			for(int i=0; i<words.length; i++){
				int diffCount = 0;
				for(int j=0; j<words[i].length(); j++){
					if(word.charAt(j) != words[i].charAt(j)){
						diffCount++;
					}
					if(diffCount > 1) break;
				}
				if(diffCount < 2 && !visit.contains(words[i])){
					visit.add(words[i]);
					qu.add(new Node(words[i], count + 1));
				}
			}
		}
		return 0;
	}
}
