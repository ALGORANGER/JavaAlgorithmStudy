package day0224;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_Tree_S1_1991 {

	private static int N;
	private static Node[] nodes;
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;

	public static class Node {
		char data;
		Node left;
		Node right;

		public Node(char data) {
			this.data = data;
		}

		public char getData() {
			return data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	public static class Tree {
		Node root;

		void add(char data, char left, char right) {
			if (root == null) {
				root = new Node(data);
				if (left != '.')
					root.left = new Node(left);
				if (right != '.')
					root.right = new Node(right);
			} else {
				find(root, data, left, right);
			}
		}

		void find(Node root, char data, char left, char right) {
			if (root == null)
				return;
			if (root.data == data) {
				if (left != '.')
					root.left = new Node(left);
				if (right != '.')
					root.right = new Node(right);
			} else {
				find(root.left, data, left, right);
				find(root.right, data, left, right);
			}
		}

	}

	private static void preOrder(Node node) {
		if (node != null) {
			sb.append(node.getData());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	private static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.getLeft());
			sb.append(node.getData());
			inOrder(node.getRight());
		}
	}

	private static void postOrder(Node node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			sb.append(node.getData());
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		nodes = new Node[N];

		Tree tree = new Tree();

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			char node = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree.add(node, left, right);
		}

		preOrder(tree.root);
		sb.append("\n");
		inOrder(tree.root);
		sb.append("\n");
		postOrder(tree.root);
		sb.append("\n");
		bw.append(sb.toString());

		br.close();
		bw.flush();
		bw.close();

	}

}
