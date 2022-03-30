package com.ssafy.algo.day0310;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class _BOJ_DFS_S1_2667 {

	static int N, M, cnt;
	static int map[][];
	static boolean visited[][];
	static int deltas[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static ArrayList<Integer> arl;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		arl = new ArrayList<>();

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			String[] str = br.readLine().split("");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(str[c]);
			}
		}
		
		//여기까지 입력

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c] && map[r][c] == 1) {  //아직 해당하지 않은 집이 있으면
					cnt = 1;
					bfs(r, c);							//bfs로 다 돌려보기
					arl.add(cnt);						//한 구획의 집 수
				}
			}

		}
		
		Collections.sort(arl);  //오름차순 정렬

		System.out.println(arl.size());
		for (int i = 0; i < arl.size(); i++) {
			System.out.println(arl.get(i));
		}

	}

	static void bfs(int r, int c) {
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {  //상하좌우로 같은 구획에 존재하는 집들 전부 파악
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
				bfs(nr, nc);
				cnt++;
			}

		}

	}

}
