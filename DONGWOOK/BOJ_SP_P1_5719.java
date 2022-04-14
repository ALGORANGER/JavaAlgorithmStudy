package _04_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_SP_P1_5719 {
	static class Node implements Comparable<Node> {
		int no, cost;

		public Node(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int V, E, S, D;
	static List<List<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			if (V == 0 && E == 0) {
				break;
			}

			for (int v = 0; v < V; v++) {
				graph.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());

			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());

			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				graph.get(from).add(new Node(to, cost));
			}

			PriorityQueue<Node> PQ = new PriorityQueue<>();
			int[] dis = new int[V];
			Arrays.fill(dis, Integer.MAX_VALUE);
			Node start = new Node(S, 0);
			dis[S] = 0;
			PQ.offer(start);
			List<Integer> remove[] = new List[V];

			for (int v = 0; v < V; v++) {
				remove[v] = new LinkedList<>();
			}

			int min = 0;
			boolean flag = false;
			while (!PQ.isEmpty()) {

				Node cur = PQ.poll();

				if (dis[cur.no] < cur.cost) {
					continue;
				}

				if (cur.no == D && !flag) {
					flag = true;
					min = cur.cost;
					continue;
				} else if (cur.no == D && flag) {
					if (min != cur.cost) {
						break;
					}
					continue;
				}

				List<Node> temp = graph.get(cur.no);

				for (Node next : temp) {
					if (dis[next.no] >= cur.cost + next.cost) {

						if (dis[next.no] > cur.cost + next.cost) {
							remove[next.no].clear();
							dis[next.no] = cur.cost + next.cost;
							PQ.offer(new Node(next.no, dis[next.no]));
						}
						remove[next.no].add(cur.no);
					}
				}
			}
			Queue<Integer> q = new ArrayDeque<>();

			q.offer(D);

			while (!q.isEmpty()) {
				int v = q.poll();
				if(v == S) {
					continue;
				}
				for (int n : remove[v]) {
					for (int index = 0; index < graph.get(n).size(); index++) {
						if (graph.get(n).get(index).no == v) {
							graph.get(n).remove(index);
							q.offer(n);
							break;
						}
					}
				}
			}

			PQ.clear();
			dis = new int[V];
			boolean[] isV = new boolean[V];
			Arrays.fill(dis, Integer.MAX_VALUE);
			start = new Node(S, 0);
			dis[S] = 0;
			PQ.offer(start);
			int answer = 0;

			while (!PQ.isEmpty()) {
				Node cur = PQ.poll();

				if (isV[cur.no]) {
					continue;
				}
				isV[cur.no] = true;

				if (cur.no == D) {
					answer = cur.cost;
					break;
				}

				List<Node> temp = graph.get(cur.no);

				for (Node next : temp) {
					if (dis[next.no] > cur.cost + next.cost) {
						dis[next.no] = cur.cost + next.cost;
						PQ.offer(new Node(next.no, dis[next.no]));
					}
				}
			}
			if (answer == 0) {
				answer = -1;
			}
			sb.append(answer+"\n");
			graph.clear();
		}
		System.out.println(sb.toString());
	}
}