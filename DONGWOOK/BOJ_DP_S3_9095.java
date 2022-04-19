package _04_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_DP_S3_9095 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[12];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int n = 4; n < 12; n++) {
			dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
		}
		
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]+"\n");
		}
		System.out.println(sb.toString());

	}

}
