package _03_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_DFS_S1_2667 {
	static int N, dong, count;
	static int[][] map, deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		
		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = (int) arr[j] - '0';
			}
		}
		
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					dong++;
					count =0;
					DFS(i, j);
					list.add(count);
				}
			}
		}
		
		
		
		Collections.sort(list);
		for(int n : list) {
			sb.append(n+"\n");
		}
		System.out.println(dong);
		System.out.println(sb.toString());
	}

	static void DFS(int row, int col) {
		
		map[row][col] = 0;
		count++;
		
		
		for(int k=0; k<4;k++) {
			int nr = row + deltas[k][0];
			int nc = col + deltas[k][1];
			
			if(isIn(nr,nc) && map[nr][nc] == 1) {
				
				DFS(nr,nc);
			}
			
		}
	}

	static boolean isIn(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}
}
