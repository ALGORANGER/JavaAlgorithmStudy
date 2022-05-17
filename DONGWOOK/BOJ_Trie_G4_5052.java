package _05_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BOJ_Trie_G4_5052 {
	static class Node{
		Map<Character, Node> childNode = new HashMap<>();
		boolean endOfword;
	}

	static class Trie{
		Node rootNode = new Node();
		
		void insert(String str) {
			Node node = this.rootNode;
			
			for(int i=0; i<str.length();i++) {
				node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
			}
			node.endOfword = true;
		}
		int search(String str) {
			Node node = this.rootNode;
			for(int i=0; i<str.length();i++) {
				node = node.childNode.getOrDefault(str.charAt(i), null);
				if(node == null) {
					return 0;
				}
			}
			return node.childNode.size();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			Trie trie = new Trie();
			int M = Integer.parseInt(br.readLine());
			String[] numbers = new String[M];
			
			for (int m = 0; m < M; m++) {
				numbers[m] = br.readLine();
				trie.insert(numbers[m]);
			}
			
			boolean beep = false;
			for (int m = 0; m < M; m++) {
				if(trie.search(numbers[m]) !=0) {
					beep = true;
					break;
				}
			}
			if(beep) {
				sb.append("NO"+"\n");
			}else {
				sb.append("YES"+"\n");			
			}
		}
		System.out.println(sb.toString());
	}

}
