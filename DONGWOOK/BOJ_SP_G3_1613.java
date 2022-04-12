package _04_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_SP_G3_1613 {
	static int V, E;
	static int[][] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		graph = new int[V + 1][V + 1];
		for (int v = 0; v <= V; v++) {
			Arrays.fill(graph[v], Integer.MAX_VALUE);
		}
		E = Integer.parseInt(st.nextToken());

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to] = 1;
		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (i == j) {
						continue;
					}
					if (k == i || k == j) {
						continue;
					}
					if (graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) {
						continue;
					}
					graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
				}
			}
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(graph[a][b]!= Integer.MAX_VALUE) {
				sb.append(-1+"\n");
			}else if(graph[b][a]!= Integer.MAX_VALUE) {
				sb.append(1+"\n");
			}else {
				sb.append(0+"\n");
			}
		}
		System.out.println(sb.toString());

	}

}
