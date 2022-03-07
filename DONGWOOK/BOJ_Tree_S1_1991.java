package _02_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Tree_S1_1991 {

	static class Node {
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

	static class tree {
		Node root;

		static public void search(Node node, String op) {
			if (node != null && node.getData() != '.') {
				if (op.equals("pre")) {
					sb.append(node.getData());
				}
				search(node.getLeft(), op);
				if (op.equals("in")) {
					sb.append(node.getData());
				}
				search(node.getRight(), op);
				if (op.equals("post")) {
					sb.append(node.getData());
				}
			}
		}
	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		tree T = new tree();
		T.root = new Node('A');

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			Node L = new Node(left);
			Node R = new Node(right);

			Node node = find(T.root, root);
			node.setLeft(L);
			node.setRight(R);
		}
		tree.search(T.root, "pre");
		sb.append("\n");
		tree.search(T.root,"in");
		sb.append("\n");
		tree.search(T.root,"post");
		sb.append("\n");
		System.out.println(sb.toString());
	}

	static public Node find(Node node, char data) {
		if (node == null) {
			return null;
		}

		if (node.getData() == data) {
			return node;
		} else {
			Node L = find(node.getLeft(), data);
			Node R = find(node.getRight(), data);
			if (L != null) {
				return L;
			} else if (R != null) {
				return R;
			}
		}
		return null;
	}

}
