package _04_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_DP_S1_16456 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = 1000000009;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][2];
		int me = 0;
		int notMe = 1;
		if (N == 1 || N == 2) {
			System.out.println(1);
		} else {
			dp[1][me] = 1;

			dp[2][me] = 1;

			dp[3][me] = 1;
			dp[3][notMe] = 1;

			for (int i = 4; i <= N; i++) {
				dp[i][me] = (dp[i - 1][me] % M + dp[i - 1][notMe] % M) % M;
				dp[i][notMe] = dp[i - 2][me] % M;
			}
			System.out.println((dp[N][me] % M + dp[N][notMe] % M) % M);
		}

	}

}
