package _03_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_Backtracking_G3_1941 {
	static char[][] map = new char[5][5];
	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[] temp = new int[7];
		combination(0, 0, temp);
		int answer = 0;

		for (List<Integer> l : list) {
			boolean flag = true;
			
			flag = isSide(l);
			
			if (!flag) {
				continue;
			} else {
				int count = 0;
				
				for (int k : l) {
					if(map[k/5][k%5] =='S') {
						count++;
					}
				}
				
				if (count >= 4) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	static void combination(int cnt, int start, int[] temp) {
		if (cnt == 7) {
			List<Integer> l = new ArrayList<>();
			for (int n : temp) {
				l.add(n);
			}
			list.add(l);
			return;
		}

		for (int i = start; i < 25; i++) {
			temp[cnt] = i;
			combination(cnt + 1, i + 1, temp);
		}
	}

	static boolean isSide(List<Integer> temp) {

		int num = temp.get(0);
		boolean[] isV = new boolean[25];
		int cnt = 1;
		isV[num] = true;

		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		while (!q.isEmpty()) {
			num = q.poll();
			int u = num - 5;
			int d = num + 5;
			int l = num - 1;
			int r = num + 1;

			if (isIn(u)&&!isV[u] && temp.contains(u)) {
				isV[u] = true;
				q.offer(u);
				cnt++;
			}
			if (isIn(d)&&!isV[d] && temp.contains(d)) {
				isV[d] = true;
				q.offer(d);
				cnt++;
			}

			if (isIn(r)&&!isV[r] && temp.contains(r) && r % 5 != 0) {
				isV[r] = true;
				q.offer(r);
				cnt++;
			}

			if (isIn(l)&&!isV[l] && temp.contains(l) && l % 5 != 4) {
				isV[l] = true;
				q.offer(l);
				cnt++;
			}
		}
		if(cnt ==7) {
			return true;
		}
		return false;
	}
	static boolean  isIn(int n) {
		return n>=0 && n<25;
	}
}
