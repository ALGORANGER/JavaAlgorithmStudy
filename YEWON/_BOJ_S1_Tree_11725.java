package week5_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _BOJ_S1_Tree_11725 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		LinkedList<Integer>[] g = new LinkedList[N+1];
		
		for(int i = 0; i <= N; i++) {
			g[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!g[a].contains(b)) g[a].add(b);
			if(!g[b].contains(a)) g[b].add(a);
		}
		
		int[] parents = new int[N+1];
		
		boolean[] visited = new boolean[N+1];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int x = queue.poll();
			for(int now : g[x]) {
				if(visited[now]) continue;
				queue.add(now);
				visited[now] = true;
				parents[now] = x;
			}
		}
		
		for(int i = 2; i <= N; i++) {
			answer.append(parents[i]).append("\n");
		}
		System.out.println(answer);
	}

}
