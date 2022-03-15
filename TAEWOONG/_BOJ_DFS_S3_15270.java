package com.ssafy.algo.day0310;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_DFS_S3_15270 {
	static int N, M, friends[][];
	static int answer;
	static boolean dancing[];
	static int max;

	// friend배열을 NxN으로 선언하고 dfs를 쓰면 시간초과
	// N이아닌 M갯수로 읽어와서 Mx2의 크기로 선언

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		friends = new int[M][2];
		dancing = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			friends[i][0] = a;
			friends[i][1] = b; // a,b는 서로 친구다
		}

//		for(int r=0;r<N;r++) {
//			for(int c=0;c<N;c++) {
//				System.out.print(friends[r][c]);
//			}
//			System.out.print(" "+dancing[r]);
//			System.out.println();
//		}
		// 여기까지 입력

		dfs(0);

		if (max % 2 ==0 && max!=N) { // 짝수면 중간에 1명더 넣어
			System.out.println(max + 1);
		} else
			System.out.println(max);

	}

	static void dfs(int cnt) {
		if (cnt >= M) {
			max = Math.max(answer, max);
			return;
		}
		// System.out.println(cnt+" "+dancing[cnt]+" "+answer);

		if (dancing[friends[cnt][0]] || dancing[friends[cnt][1]]) { // 이미 두 친구중 하나가 짝이 있는경우
			dfs(cnt + 1); // 같이 춤 못춘다
			
			
		}else { // 둘이서 짝지을수 있을 땐
			dancing[friends[cnt][0]] = dancing[friends[cnt][1]] = true;
			answer += 2;
			dfs(cnt + 1);
			dancing[friends[cnt][0]] = dancing[friends[cnt][1]] = false; // 다음 경우의수
			answer -= 2;
			dfs(cnt + 1);
		}

	}

}
