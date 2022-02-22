package _02_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_String_S2_5525 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String IOI = br.readLine();
		char next = 'I';
		int answer = 0;
		int cnt = 0;

		for (int i = 0; i < IOI.length(); i++) {
			if (IOI.charAt(i) == next) {
				cnt++;
				if (next == 'I') {
					next = 'O';
				} else {
					next = 'I';
				}
			} else {

				if (IOI.charAt(i) == 'I') {
					next = 'I';
					int n = cnt / 2;
					if (n >= N) {
						answer += n - N + 1;
					}
					cnt = 0;
					if (IOI.charAt(i) == next) {
						cnt++;
						if (next == 'I') {
							next = 'O';
						} else {
							next = 'I';
						}
					}
				} else {
					if (cnt >= 3) {
						int n = (cnt - 2) / 2;
						if (n >= N) {
							answer += n - N + 1;
						}
					}
					cnt = 0;
				}

			}
		}
		if (next == 'O') {
			if (cnt >= 3) {
				int n = cnt / 2;
				if (n >= N) {
					answer += n - N + 1;
				}
			}
		}else {
			int n = (cnt-1) / 2;
			if (n >= N) {
				answer += n - N + 1;
			}
		}
		System.out.println(answer);
	}

}
