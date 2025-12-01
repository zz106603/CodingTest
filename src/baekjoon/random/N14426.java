package baekjoon.random;

import java.io.*;
import java.util.StringTokenizer;

public class N14426 {
    static Node root = new Node();

    public static class Node{
        Node[] child = new Node[26];

        void insert(char[] word){
            Node cur = root;
            for(char c : word){
                int idx = c - 'a';
                if(cur.child[idx] == null){
                    cur.child[idx] = new Node();
                }
                cur = cur.child[idx];
            }
        }

        boolean find(char[] word){
            Node cur = root;
            for(char c : word){
                int idx = c - 'a';
                if(cur.child[idx] == null){
                    return false;
                }
                cur = cur.child[idx];
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            char[] cArr = br.readLine().toCharArray();
            root.insert(cArr);
        }

        int count = 0;
        for(int i=0; i<M; i++){
            char[] cArr = br.readLine().toCharArray();
            if(root.find(cArr)) count++;
        }

        System.out.println(count);

    }
}
