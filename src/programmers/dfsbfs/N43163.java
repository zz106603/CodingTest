package programmers.dfsbfs;

import org.w3c.dom.Node;

import java.io.IOException;
import java.util.*;


public class N43163 {

	public static class Node{
		String word;
		int count;

		public Node(String word, int count){
			this.word = word;
			this.count = count;
		}
	}

	static Set<String> wordSet;
	public static void main(String[] args) throws IOException{
		String begin = "hit";
		String target = "cog";
		String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};

		wordSet = new HashSet<>(Arrays.asList(words));
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

			Iterator<String> it = wordSet.iterator();
			// 이렇게 HashSet에 있는 word들을 지워나가면 반복문에 재입장 했을 때 반복 개수가 줄어들어 효율적
			// 만약에 visit(set)에 추가되는 구조로 만들어서 contains로 검증한다면 그 이후에 while동작에 여전히 모든 words를 검사해야 하는 경우로 O(N*M)
			while(it.hasNext()){
				String next = it.next();

				boolean flag = true;
				int diffCount = 0;
				for(int i=0; i<next.length(); i++){
					if(word.charAt(i) != next.charAt(i)){
						diffCount++;
						if(diffCount > 1){
							flag = false;
							break;
						}
					}
				}
				if(flag){
					qu.add(new Node(next, count + 1));
					it.remove();
				}
			}
		}

		return 0;
	}
}
