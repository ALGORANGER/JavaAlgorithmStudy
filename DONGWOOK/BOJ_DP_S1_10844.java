package _04_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_DP_S1_10844 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = 1_000_000_000;
		int[][] dp = new int[N + 1][10];
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][1];
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][8];
				} else {
					dp[i][j] = (dp[i - 1][j - 1] % M + dp[i - 1][j + 1] % M) % M;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += dp[N][i];
			answer %= M;
		}
		System.out.println(answer);
	}
	/*
	 * 
dp[2][0] = dp[1][1]
dp[2][1] = dp[1][2] + dp[1][0]
dp[2][2] = dp[1][1] + dp[1][3]
dp[2][3] = dp[1][2] + dp[1][4]
dp[2][4] = dp[1][2] + dp[1][4]
dp[2][5] = dp[1][1] + dp[1][3]
dp[2][6] = dp[1][2] + dp[1][4]
dp[2][7] = dp[1][1] + dp[1][3]
dp[2][8] = dp[1][2] + dp[1][4]
dp[2][9] = dp[1][8]

dp[3][0] = dp[2][1]
dp[3][1] = dp[2][2] + do[2][0]
dp[3][2] = dp[2][1] + dp[2][3]
dp[3][3] = dp[2][2] + dp[2][4]
dp[3][4] = dp[2][3] + dp[2][5]
dp[3][5] = dp[2][4] + dp[2][6]
dp[3][6] = dp[2][5] + dp[2][7]
dp[3][7] = dp[2][6] + dp[2][8]
dp[3][8] = dp[2][7] + dp[2][9]
dp[3][9] = dp[2][8]
*/
}
