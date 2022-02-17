package _02_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_String_S4_1120 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= B.length() - A.length(); i++) {
			int cnt = 0;
			for (int j = 0; j < A.length(); j++) {
				if (A.charAt(j) == B.charAt(i + j)) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		int answer = A.length() - max;
		System.out.println(answer);

	}

}
