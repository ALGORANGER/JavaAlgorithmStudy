package _02_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Tree_S2_11725 {
	static class Node {
		int no;
		
		//부모노드
		int from;
		
		Node link;

		public Node(int no, Node link) {
			this.no = no;
			this.link = link;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		Node[] list = new Node[N + 1];
		int[] parent = new int[N + 1];
		boolean[] isV = new boolean[N + 1];
		for (int n = 0; n < N - 1; n++) {
			st = new StringTokenizer(br.readLine());
			//양방향 연결리스트로 정점 저장
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			list[first] = new Node(second, list[first]);
			list[second] = new Node(first, list[second]);

		}
		//1번 시작 지점 저장
		isV[0] = true;
		isV[1] = true;
		Node node = list[1];
		while (node != null) {
			//루트 부모 저장
			node.from = 1;
			node = node.link;
		}
		Queue<Node> q = new LinkedList<>();
		q.offer(list[1]);
		
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			while (n != null) {
				//부모 등록 했는지 확인
				if (!isV[n.no]) {
					
					//부모 등록
					isV[n.no] = true;
					
					//나의 부모 저장
					parent[n.no] = n.from;
					
					//나랑 연결된 리스트들에게 내가 부모인걸 저장
					Node next = list[n.no];
					while (next != null) {
						if (!isV[next.no]) {
							next.from = n.no;
						}
						next = next.link;
					}
					
					//큐에 저장
					q.offer(list[n.no]);
					
					
					n = n.link;
				} else {
					n = n.link;
				}
			}
		}
		for(int i =2; i<=N;i++) {
			sb.append(parent[i]+"\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

}
