package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_1922_네트워크연결 {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	
	static int N, E;
	static int[] parents;
	static Edge[] edgeList;
	
	public static void makeSet() {
		parents = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		edgeList = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edgeList);
		makeSet();
		
		int result = 0, cnt = 0;
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt == N-1) break;
			}
		}
		System.out.println(result);

	}

}
