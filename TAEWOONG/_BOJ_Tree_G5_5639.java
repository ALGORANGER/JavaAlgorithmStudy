package com.ssafy.algo.day2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_Tree_G5_5639 {
	
	static class Node{
		int root;
		Node leftN;
		Node rightN;
		
		public Node(int root, Node leftN, Node rightN) {
			this.root = root;
			this.leftN = leftN;
			this.rightN = rightN;
		}
		
		public void add(int root) {
			if(this.root>root) {
				if(this.leftN==null) {
					this.leftN=new Node(root,null,null);
				}else {
					this.leftN.add(root);
				}
			}else {
				if(this.rightN==null) {
					this.rightN=new Node(root,null,null);
				}else {
					this.rightN.add(root);
				}
			}
		}		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Node node = new Node(Integer.parseInt(br.readLine()),null,null);
		
		while(br.ready()) {
			node.add(Integer.parseInt(br.readLine()));
		}
		
		postOrder(node);

	}
	
	static void postOrder(Node node) {
		if(node==null) return;
		
		postOrder(node.leftN);
		postOrder(node.rightN);
		System.out.println(node.root);
		
	}

}
