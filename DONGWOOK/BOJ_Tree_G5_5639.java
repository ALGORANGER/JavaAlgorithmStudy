package _03_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_Tree_G5_5639 {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
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
					sb.append(node.getData()+"\n");
				}
			}
		}
	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int root = Integer.parseInt(br.readLine());
		tree T = new tree();
		T.root = new Node(root);

		String str = null;
		
		while (br.ready()) {
			int data = Integer.parseInt(br.readLine());
			// 루트랑 대소 비교, 자리가 비어 있다면 넣고, 있다면 그 노드로 들어가라
			find(T.root, data);
		}
		tree.search(T.root, "post");
		System.out.println(sb.toString());
	}

	static public void find(Node node, int data) {
		if (node.getData() > data) {
			if (node.getLeft() != null) {
				find(node.getLeft(), data);
			} else {
				node.setLeft(new Node(data));
			}
		} else if (node.getData() < data) {
			if (node.getRight() != null) {
				find(node.getRight(), data);
			} else {
				node.setRight(new Node(data));
			}
		}
	}
}
