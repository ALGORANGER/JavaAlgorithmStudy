package _04_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_SP_G5_21278 {
	static int V, E;
	static int[][] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new int[V + 1][V + 1];

		for (int i = 0; i <= V; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
			graph[i][i] = 0;
		}

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = 1;
			graph[b][a] = 1;
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
		int[] minCost = new int[V + 1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		int min = Integer.MAX_VALUE;
		int A = 0, B = 0;
		for (int i = 1; i < V; i++) {
			for (int j = i + 1; j <= V; j++) {
				int sum = 0;
				for (int k = 1; k <= V; k++) {
					minCost[k] = Math.min(graph[i][k], graph[j][k]);
					sum += (minCost[k] * 2);
				}
				if (min > sum) {
					min = sum;
					A = i;
					B = j;
				}
			}
		}
		System.out.printf("%d %d %d", A, B, min);
	}

}
