package _03_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_BFS_G4_2206 {

	static class route {
		int row;
		int col;
		int count;
		boolean block = false;

		public route(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}

	static int N, M;
	static int[][] map, brokenMap, countMap, deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		countMap = new int[N][M];
		brokenMap = new int[N][M];
		for (int n = 0; n < N; n++) {
			char[] temp = br.readLine().toCharArray();
			Arrays.fill(countMap[n], Integer.MAX_VALUE);
			Arrays.fill(brokenMap[n], Integer.MAX_VALUE);
			for (int m = 0; m < M; m++) {
				map[n][m] = (int) temp[m] - '0';
			}
		}

		Queue<route> q = new LinkedList<>();

//		시작지점 초기화
		route r = new route(0, 0, 1);
		countMap[0][0] = 1;
		q.offer(r);
		int min = Integer.MAX_VALUE;
		int answer = -1;

		while (!q.isEmpty()) {

			r = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = r.row + deltas[k][0];
				int nc = r.col + deltas[k][1];

				if (isIn(nr, nc)) {
					if (map[nr][nc] == 0) {
						route rt = new route(nr, nc, r.count + 1);
						rt.block = r.block;
						
						if(rt.block) {
							if (brokenMap[nr][nc] > rt.count) {
								brokenMap[nr][nc] = rt.count;
								if (nr == N - 1 && nc == M - 1 && min > rt.count) {
									min = rt.count;
									answer = min;
								}
								q.offer(rt);
							}
						}else {
							if (countMap[nr][nc] > rt.count) {
								countMap[nr][nc] = rt.count;
								if (nr == N - 1 && nc == M - 1 && min > rt.count) {
									min = rt.count;
									answer = min;
								}
								q.offer(rt);
							}
						}
					} else {
						if (!r.block) {
							route rt = new route(nr, nc, r.count + 1);
							if (brokenMap[nr][nc] > rt.count) {
								brokenMap[nr][nc] = rt.count;
							}
							rt.block = true;
							q.offer(rt);
						}
					}
				}
			}
		}
		if(N==1 && M==1) {
			answer = 1;
		}
		System.out.println(answer);
	}

	static boolean isIn(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < M;
	}
}
