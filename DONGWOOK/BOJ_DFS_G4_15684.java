package _03_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_DFS_G4_15684 {
	static class Pair {
		int first;
		int second;
		int height;

		public Pair(int first, int second, int height) {
			this.first = first;
			this.second = second;
			this.height = height;
		}
	}

	static int N, M, H, answer = -1;
	static int[][] map;
	static boolean find;
	static List<Pair> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H + 1][N + 1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = b + 1;
			map[a][b + 1] = b;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= H; j++) {
				if (map[j][i] == 0 && map[j][i + 1] == 0) {
					list.add(new Pair(i, i + 1, j));
				}
			}
		}

		for (int t = 0; t <= 3; t++) {

			// 새로 그릴 맵 복사
			int[][] temp = new int[H + 1][N + 1];

			for (int i = 0; i < H + 1; i++) {
				temp[i] = Arrays.copyOf(map[i], N + 1);
			}
			
			DFS(temp, 0, t, 0);
			if(find) break;

		}
		
		System.out.println(answer);
	}

	static void DFS(int[][] temp, int idx, int t, int L) {
		if (L == t) {

			int count = 0;
			for (int start = 1; start <= N; start++) {
				int col = start;
				int row = 0;
				while (row < H + 1) {
					if (temp[row][col] != 0) {
						col = temp[row][col];
					}
					row++;
				}

				if (start == col) {
					count++;
				}

			}
			if (count == N) {
				find = true;
				answer = t;
			}
			return;
		}

		for (int index = idx; index < list.size(); index++) {

			int T = t;
			int cur = index;

			Pair p = list.get(cur);
			if (temp[p.height][p.first] == 0 && temp[p.height][p.second] == 0) {
				temp[p.height][p.first] = p.second;
				temp[p.height][p.second] = p.first;
				DFS(temp, index + 1, T, L+1);
				if(find) return;
				temp[p.height][p.first] = 0;
				temp[p.height][p.second] = 0;
			}
		}
	}
}
