package com.ssafy.algo.day2024;

import java.util.StringTokenizer;
import java.io.*;

public class _BOJ_Tree_S1_1991 {
	
	static class Node{
		String root;
		Node leftN;
		Node rightN;
		
		public Node(String root, Node leftN, Node rightN) {
			this.root = root;
			this.leftN = leftN;
			this.rightN = rightN;
		}
		
		
	}
	
	static Node node;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			if(node==null) {
				node = new Node(a,null,null);
				if(!b.equals(".")) node.leftN = new Node(b,null,null);
				if(!c.equals(".")) node.rightN = new Node(c,null,null);	
			}else {				
				search(node,a,b,c);
			}
		}
		
		preOrder(node);
		System.out.println();
		inOrder(node);
		System.out.println();
		postOrder(node);
	}
	
	public static void search(Node node, String a, String b, String c) {
		if(node==null)
			return;
		
		if(node.root.equals(a)) {
			if(!b.equals(".")) node.leftN = new Node(b,null,null);
			if(!c.equals(".")) node.rightN = new Node(c,null,null);
		}else {
			search(node.leftN,a,b,c);
			search(node.rightN,a,b,c);
		}
		
	}
	
	public static void preOrder(Node node) {
		if(node!=null) {
			System.out.print(node.root);
			preOrder(node.leftN);
			preOrder(node.rightN);
		}
	}
	
	public static void inOrder(Node node) {
		if(node!=null) {			
			inOrder(node.leftN);
			System.out.print(node.root);
			inOrder(node.rightN);
		}
	}
	
	public static void postOrder(Node node) {
		if(node!=null) {			
			postOrder(node.leftN);
			postOrder(node.rightN);
			System.out.print(node.root);
		}
	}

}
