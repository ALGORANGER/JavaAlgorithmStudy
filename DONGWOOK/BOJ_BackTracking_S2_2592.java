package _03_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_BackTracking_S2_2592 {
	static String[] strArr;
	static int N;
	static boolean[] isV = new boolean[10];
	static Set<Long> set = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		strArr = br.readLine().split(" ");
		int[] temp = new int[N + 1];
		Arrays.fill(temp, 0);
		DFS(0, temp);

		List<Long> list = new ArrayList<>();

		for (long n : set) {
			list.add(n);
		}
		Collections.sort(list);
		long min = list.get(0);
		long max = list.get(list.size() - 1);

		long t = min;

		int k = 0;
		while ((t / 10) != 0) {
			t /= 10;
			k++;
		}

		System.out.print(max + "\n");
		if (k == N - 1) {
			System.out.print(0);
		}
		System.out.println(min);
	}

	static void DFS(int cnt, int[] temp) {
		if (cnt == N + 1) {
			long num = 0;
			for (int i = 0; i < temp.length; i++) {
				num = (10 * num + temp[i]);
			}
			set.add(num);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (cnt == 0) {
				isV[i] = true;
				temp[cnt] = i;
				DFS(cnt + 1, temp);
				isV[i] = false;
			} else {
				if (!isV[i]) {
					if (strArr[cnt - 1].equals(">") && temp[cnt - 1] > i) {
						isV[i] = true;
						temp[cnt] = i;
						DFS(cnt + 1, temp);
						isV[i] = false;
					} else if (strArr[cnt - 1].equals("<") && temp[cnt - 1] < i) {
						isV[i] = true;
						temp[cnt] = i;
						DFS(cnt + 1, temp);
						isV[i] = false;
					}
				}
			}
		}

	}
}
