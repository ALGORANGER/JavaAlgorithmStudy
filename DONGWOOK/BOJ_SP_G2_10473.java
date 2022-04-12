package _04_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_SP_G2_10473 {
	static class Edge {
		double x;
		double y;

		public Edge(double x, double y) {
			this.x = x;
			this.y = y;
		}

	}

	static class Node implements Comparable<Node> {
		int no;
		double cost;

		public Node(int no, double cost) {
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.cost, o.cost);
		}
	}

	static double[][] graph;
	static List<Edge> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double sX = Double.parseDouble(st.nextToken());
		double sY = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double eX = Double.parseDouble(st.nextToken());
		double eY = Double.parseDouble(st.nextToken());
		int V = Integer.parseInt(br.readLine());

		list.add(new Edge(sX, sY));
		for (int v = 0; v < V; v++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			list.add(new Edge(x, y));
		}
		list.add(new Edge(eX, eY));

		graph = new double[V + 2][V + 2];

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				graph[i][j] = Math.sqrt(Math.pow(Math.abs(list.get(i).x - list.get(j).x), 2)
						+ Math.pow(Math.abs(list.get(i).y - list.get(j).y), 2));
				graph[j][i] = graph[i][j];
			}

		}
		for (int i = 0; i < V + 2; i++) {
			graph[0][i] /= 5;
			graph[V + 1][i] /= 5;
		}

		for (int i = 1; i < V + 1; i++) {
			for (int j = 0; j <= V + 1; j++) {
				if (graph[i][j] > 50) {
					graph[i][j] = (graph[i][j] - 50) / 5 + 2;
				} else if (graph[i][j] > 30) {
					graph[i][j] = (50 - graph[i][j]) / 5 + 2;
				} else {
					graph[i][j] /= 5;
				}
			}
		}

		double[] dis = new double[V + 2];
		boolean[] isV = new boolean[V + 2];
		Arrays.fill(dis, Double.MAX_VALUE);

		dis[0] = 0;

		PriorityQueue<Node> PQ = new PriorityQueue<>();
		PQ.offer(new Node(0, 0));
		double answer = 0;
		while (!PQ.isEmpty()) {
			Node node = PQ.poll();
			if (isV[node.no]) {
				continue;
			}

			isV[node.no] = true;

			if (node.no == V + 1) {
				answer = node.cost;
				break;
			}

			for (int i = 0; i < V + 2; i++) {
				if (dis[i] > dis[node.no] + graph[node.no][i]) {
					dis[i] = dis[node.no] + graph[node.no][i];
					PQ.offer(new Node(i, dis[i]));
				}
			}

		}

		System.out.printf("%.6f", answer);
	}

}
