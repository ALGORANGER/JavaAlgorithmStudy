package _03_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_MST_G3_1774 {
	static class Edge implements Comparable<Edge> {
		int node;
		double weight;

		public Edge(int node, double weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}

	}

	static int E, V, M;
	static int[][] vertex;
	static List<List<Edge>> edgeList = new ArrayList<>();
	static boolean[] isV;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		isV = new boolean[V + 1];
		vertex = new int[V + 1][2];

		for (int i = 0; i <= V; i++) {
			edgeList.add(new ArrayList<Edge>());
		}

		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			vertex[i][0] = x;
			vertex[i][1] = y;
		}

		for (int i = 1; i < V; i++) {
			for (int j = i + 1; j <= V; j++) {
				double dis = Math.sqrt(Math.pow(Math.abs(vertex[i][0] - vertex[j][0]), 2)
						+ Math.pow(Math.abs(vertex[i][1] - vertex[j][1]), 2));
				edgeList.get(i).add(new Edge(j, dis));
				edgeList.get(j).add(new Edge(i, dis));
			}
		}

		PriorityQueue<Edge> PQ = new PriorityQueue<>();
		List<Integer>[] list = new List[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);

			edgeList.get(a).add(new Edge(b, 0));
			edgeList.get(b).add(new Edge(a, 0));

		}

		PQ.offer(new Edge(1, 0));

		double answer = 0;

		while (!PQ.isEmpty()) {

			Edge edge = PQ.poll();

			if (isV[edge.node]) {
				continue;
			}

			isV[edge.node] = true;

			answer += edge.weight;

			cnt++;

			if (cnt == V ) {
				break;
			}

			for (Edge e : edgeList.get(edge.node)) {
				if (!isV[e.node]) {
					PQ.offer(e);
				}
			}
		}
		System.out.printf("%.2f", answer);
	}

}
