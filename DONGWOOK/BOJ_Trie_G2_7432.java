package _05_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BOJ_Trie_G2_7432 {
	static class Node {
		Map<String, Node> children = new TreeMap<>();
		boolean endOfCave;
	}

	static class Trie {
		Node rootNode = new Node();

		void insert(String[] strs) {
			Node node = this.rootNode;
			for (int i = 0; i < strs.length; i++) {
				node = node.children.computeIfAbsent(strs[i], key -> new Node());
			}
			node.endOfCave = true;
		}

		void find() {
			Node node = this.rootNode;
			for (Entry<String, Node> entry : node.children.entrySet()) {
				print(entry.getKey(),entry.getValue(),0);
			}
		}

		void print(String word, Node node, int cnt) {
			for(int i=0; i<cnt;i++) {
				sb.append(" ");
			}
			sb.append(word+"\n");
			for (Entry<String, Node> entry : node.children.entrySet()) {
				print(entry.getKey(), entry.getValue(),cnt+1);
			}
		}
	}
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		for (int n = 0; n < N; n++) {
			String[] strs = br.readLine().split("\\\\");
			trie.insert(strs);
		}
		trie.find();
		System.out.println(sb.toString());
	}
}
