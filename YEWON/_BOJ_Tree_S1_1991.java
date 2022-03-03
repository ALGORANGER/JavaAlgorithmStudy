package week5_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _BOJ_S1_1991_트리순회 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N;

	
	static class Node{
		private char data;
		private Node leftNode;
		private Node rightNode;
		
		public Node(char data) {
			this.data = data;
		}
		
	}
	
	static class Tree{
		Node root;
		
		public void add(char data, char left, char right) {
			if(root == null) { // 루트가 없는 경우
				root = new Node(data);
				
				// 좌, 우 자식 넣기
				if(left != '.') { 
					root.leftNode = new Node(left);
				}
				if(right != '.') {
					root.rightNode = new Node(right);
				}
			}else { // data에 해당하는 노드 찾기
				find(root, data, left, right);
			}
		}
		
		public void find(Node root, char data, char left, char right) {
			if(root == null) {
				return;
			}else if(root.data == data) {
				if(left != '.') {
					root.leftNode = new Node(left);
				}
				if(right != '.') {
					root.rightNode = new Node(right);
				}
			}else {
				find(root.leftNode, data, left, right);
				find(root.rightNode, data, left, right);
			}
				
		}
		
		public void preOrder(Node root) { //부모 왼 오
			if(root != null) {
				answer.append(root.data);
				preOrder(root.leftNode);
				preOrder(root.rightNode);
			}
		}
		
		public void inOrder(Node root) {  //왼 부모 오
			if(root != null) {
				inOrder(root.leftNode);
				answer.append(root.data);
				inOrder(root.rightNode);
			}
			
		}
		
		public void postOrder(Node root) {  //왼 오 부모
			if(root != null) {
				postOrder(root.leftNode);
				postOrder(root.rightNode);
				answer.append(root.data);
			}
			
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		Tree tree = new Tree();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			tree.add(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
		}
		
		
		tree.preOrder(tree.root);
		answer.append("\n");
		
		
		tree.inOrder(tree.root);
		answer.append("\n");
		
		tree.postOrder(tree.root);
		
		System.out.println(answer);

	}

}
