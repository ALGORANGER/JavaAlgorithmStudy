package _03_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_MST_G3_14621 {
	static int V, E;
	static boolean[] isV;
	static List<Edge>[] edgeList;

	static class Edge implements Comparable<Edge> {
		int node;
		int weight;

		public Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		Set<Integer> M = new HashSet<>();
		Set<Integer> W = new HashSet<>();
		edgeList = new List[V + 1];
		isV = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			edgeList[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= V; i++) {
			String s = st.nextToken();
			if (s.equals("M")) {
				M.add(i);
			} else {
				W.add(i);
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			if ((M.contains(a) && M.contains(b)) || (W.contains(a) && W.contains(b))) {
				continue;
			}

			edgeList[a].add(new Edge(b, w));
			edgeList[b].add(new Edge(a, w));

		}

		PriorityQueue<Edge> PQ = new PriorityQueue<>();
		boolean flag = false;
		PQ.offer(new Edge(1, 0));
		int answer = 0;
		int cnt = 0;
		while (!PQ.isEmpty()) {
			Edge edge = PQ.poll();

			if (isV[edge.node]) {
				continue;
			}
			isV[edge.node] = true;
			answer += edge.weight;
			cnt++;
			if (cnt == V) {
				flag = true;
				break;
			}

			for (Edge e : edgeList[edge.node]) {
				if (!isV[e.node]) {
					PQ.offer(e);
				}
			}

		}
		if (!flag) {
			answer = -1;
		}
		System.out.println(answer);
	}

}
