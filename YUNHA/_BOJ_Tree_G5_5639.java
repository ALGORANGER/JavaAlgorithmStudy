package com.ssafy.algo.day0302;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _BOJ_Tree_G5_5639 {

	private static StringBuilder sb = new StringBuilder();

	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		void add(int data) {
			if (data < this.data) {
				if (this.left == null) {
					this.left = new Node(data);
				} else {
					this.left.add(data);
				}
			} else {
				if (this.right == null) {
					this.right = new Node(data);
				} else {
					this.right.add(data);
				}
			}
		}
	}

	private static void postOrder(Node node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			sb.append(node.getData() + "\n");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Node root = new Node(Integer.parseInt(br.readLine()));

		while (br.ready()) {
			root.add(Integer.parseInt(br.readLine()));
		}

		postOrder(root);

		bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();

	}

}
