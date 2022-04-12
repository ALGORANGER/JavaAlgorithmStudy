package _04_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_SP_G4_1261 {
	static class RC {
		int r;
		int c;

		public RC(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int H, W;
	static int[][] map, table, deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		table = new int[H][W];

		for (int i = 0; i < H; i++) {
			char[] arr = br.readLine().toCharArray();
			Arrays.fill(table[i], Integer.MAX_VALUE);
			for (int j = 0; j < W; j++) {
				map[i][j] = arr[j] - '0';
			}
		}

		Queue<RC> q = new ArrayDeque<>();

		q.offer(new RC(0, 0));
		table[0][0] = 0;

		while (!q.isEmpty()) {
			RC rc = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = rc.r + deltas[k][0];
				int nc = rc.c + deltas[k][1];

				if (isIn(nr, nc) && table[rc.r][rc.c] + map[nr][nc] < table[nr][nc]) {
					table[nr][nc] = table[rc.r][rc.c] + map[nr][nc];
					q.offer(new RC(nr, nc));
				}

			}

		}
		System.out.println(table[H-1][W-1]);
	}

	static boolean isIn(int row, int col) {
		return row >= 0 && row < H && col >= 0 && col < W;
	}
}
