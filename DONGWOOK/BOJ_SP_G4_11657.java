package _04_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_SP_G4_11657 {
	static class Node {
		int no, w;

		public Node(int no, int w) {
			this.no = no;
			this.w = w;
		}

	}

	static int V, M;
	static long[] dis;
	static List<List<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int v = 0; v <= V; v++) {
			graph.add(new ArrayList<>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));

		}

		dis = new long[V + 1];

		Arrays.fill(dis, Long.MAX_VALUE);
		if (bellmanFord()) {
			System.out.println(-1);
		} else {
			for (int i = 2; i < dis.length; i++) {
				if (dis[i] == Long.MAX_VALUE) {
					System.out.println(-1);
				} else {
					System.out.println(dis[i]);
				}
			}
		}

	}

	static boolean bellmanFord() {
		dis[1] = 0;

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j < graph.size(); j++) {
				for (Node node : graph.get(j)) {
					if (dis[j] != Long.MAX_VALUE && dis[j] + node.w < dis[node.no]) {
						dis[node.no] = dis[j] + node.w;
						if (i == V) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
