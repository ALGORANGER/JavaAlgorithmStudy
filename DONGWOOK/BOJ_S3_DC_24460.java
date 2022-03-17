package _03_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_DC_24460 {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (N == 1) {
			System.out.println(map[0][0]);
			return;
		}
		int ans = DC(0, 0, N);
		System.out.println(ans);
	}

	static int DC(int row, int col, int n) {
		int[] temp = new int[4];
		int cnt = 0;
		
		if (n == 2) {
			for (int i = row; i < row + 2; i++) {
				for (int j = col; j < col + 2; j++) {
					temp[cnt++] = map[i][j];
				}
			}
			Arrays.sort(temp);
			return temp[1];
		}

		temp[cnt++] = DC(row, col, n/2);
		temp[cnt++] = DC(row+n/2, col, n/2);
		temp[cnt++] = DC(row, col+n/2, n/2);
		temp[cnt++] = DC(row+n/2,col+n/2, n/2);

		Arrays.sort(temp);
		return temp[1];
	}
}
