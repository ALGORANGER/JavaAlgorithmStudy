package _03_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_MST_G4_1922 {
	static int V, E;
	static List<Edge>[] edgeList;
	static boolean[] isV;

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		edgeList = new List[V + 1];
		isV = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			edgeList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edgeList[a].add(new Edge(b, w));
			edgeList[b].add(new Edge(a, w));
		}

		PriorityQueue<Edge> PQ = new PriorityQueue<>();

		PQ.offer(new Edge(1, 0));
		int answer = 0;
		int cnt = 0;
		while (!PQ.isEmpty()) {
			Edge edge = PQ.poll();

			if (isV[edge.to]) {
				continue;
			}
			isV[edge.to] = true;
			answer += edge.weight;
			cnt++;
			if (cnt == V) {
				break;
			}

			for (Edge e : edgeList[edge.to]) {
				if (!isV[e.to]) {
					PQ.offer(e);
				}
			}

		}
		System.out.println(answer);
	}

}
