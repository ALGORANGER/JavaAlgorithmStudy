package _03_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_BFS_S2_2210 {
	static int[][] map = new int[5][5] , deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };;
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				DFS(i,j,0,0);
			}
		}
		System.out.println(set.size());
	}
	static void DFS(int row, int col, int R, int num) {
		if(R == 6) {
			set.add(num);
			return;
		}
		
		num += 10*num + map[row][col];
		
		for(int k=0; k<4;k++) {
			int nr = row + deltas[k][0];
			int nc = col + deltas[k][1];
			if(isIn(nr,nc)) {
				DFS(nr,nc, R+1, num);
			}
		}
	}

	static boolean isIn(int row, int col) {
		return row >= 0 && row < 5 && col >= 0 && col < 5;
	}
}
