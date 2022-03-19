package _03_3;

import java.io.*;
import java.util.*;

public class BOJ_DC_G5_3020 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] SJ = new int[2][H + 1]; // SJ : 석순과 종유석 높이에 따른 개수를 담을 배열, 0 = 석순, 1 = 종유석
		int[] dp = new int[H + 1]; // 해당 높이에 부딪히는 벽의 개수를 담을 dp 배열

		int index = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			SJ[(index++) % 2][num] += 1;
		}

		/*
		 * dp[1] = N/2개
		 * dp[2] = dp[1] - 길이 1인 석순 개수 + 길이 H-1인 종유석 개수
		 * dp[3] = dp[2] - 길이 2인 석순 개수 + 길이 H-2인 종유석 개수
		 * ...
		 * ...
		 * dp[H] = dp[H-1] -길이 H-1인 석순 개수 + 길이 1인 종유석 개수
		 */

		dp[1] = N / 2;
		int min = dp[1];
		int cnt = 1;

		for (int i = 2; i <= H; i++) {
			dp[i] = dp[i - 1] - SJ[0][i - 1] + SJ[1][H - (i - 1)];
			if (min > dp[i]) {
				min = dp[i];
				cnt = 1;
			} else if (min == dp[i]) {
				cnt++;
			}
		}

		System.out.printf("%d %d", min, cnt);
	}

}
