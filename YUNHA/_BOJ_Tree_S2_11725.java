package com.ssafy.algo.day0212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;


public class _BOJ_Tree_S2_11725 {

	private static int N;
	private static ArrayList<Integer>[] list;
	private static int[] parent;
	private static boolean[] visited;
	
	public static void bfs(int root) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(root);
		visited[root] = true;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			for(int next: list[tmp]) {
				if(!visited[next]) {
					visited[next] = true;
					parent[next] = tmp;
					queue.add(next);
				}
			}
		}
	}
	
	public static void dfs(int node) {
		visited[0] = true;
		for(int next: list[node]) {
			if(!visited[next]) {
				visited[next] = true;
				parent[next] = node;
				dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		
		for(int n = 1; n < N+1; n++) {
			list[n] = new ArrayList<>();
		}
		
		for(int n = 0; n < N - 1; n++) {
			String[] str = br.readLine().split(" ");
			int v1 = Integer.parseInt(str[0]);
			int v2 = Integer.parseInt(str[1]);
			list[v1].add(v2);
			list[v2].add(v1);
		}
		
		// bfs(1);
		dfs(1); 
		
		for(int i = 2; i < N+1; i++) {
			bw.append(parent[i] + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}

