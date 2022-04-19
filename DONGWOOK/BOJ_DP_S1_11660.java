package _04_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_DP_S1_11660 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		int[][] dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[0][0] = map[0][0];
				if (i == 0 && j > 0) {
					dp[i][j] = map[i][j] + dp[i][j - 1];
				}
				if (j == 0 && i > 0) {
					dp[i][j] = map[i][j] + dp[i - 1][j];
				}

				if (i > 0 && j > 0) {
					dp[i][j] = map[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
				}

			}
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			int answer = 0;
			if (sx == 0 && sy == 0) {
				answer = dp[ex][ey];
			} else if (sx == 0) {
				answer = dp[ex][ey] - dp[ex][sy - 1];
			} else if (sy == 0) {
				answer = dp[ex][ey] - dp[sx - 1][ey];
			} else {
				answer = dp[ex][ey] - dp[ex][sy - 1] - dp[sx - 1][ey] + dp[sx - 1][sy - 1];
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
