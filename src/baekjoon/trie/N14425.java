package baekjoon.trie;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class N14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        /*
            HashSet 방법
         */
//        HashSet<String> set = new HashSet<>();
//        for(int i=0; i<N; i++){
//            set.add(br.readLine());
//        }
//
//        for(int i=0; i<M; i++){
//            if(set.contains(br.readLine())){
//                answer++;
//            }
//        }

        /*
            트라이(Trie) 방법
         */
        Trie trie = new Trie();

        for(int i=0; i<N; i++){
            trie.insert(br.readLine());
        }

        for(int i=0; i<M; i++){
            if(trie.search(br.readLine())){
                answer++;
            }
        }

        System.out.println(answer);
    }
}

class Node{
    boolean endFlag;
    Node[] next = new Node[26];
}

class Trie{
    Node root = new Node();

    /*
        1. 자식 위치 인덱스를 찾는다
        2. 자식이 비어있으면 new Node()
        3. 현재 위치를 이동한 자식 위치로 이동
     */
    void insert(String word){
        Node cur = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(cur.next[idx] == null){
                cur.next[idx] = new Node();
            }
            cur = cur.next[idx];
        }
        cur.endFlag = true;
    }

    boolean search(String word){
        Node cur = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(cur.next[idx] == null) return false;
            cur = cur.next[idx];
        }
        return cur.endFlag;
    }
}
