package _03_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_DC_G4_2448 {
	static int e;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int n = N / 3;

		map = new char[N][2 * N];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(map[i], ' ');
		}
		
		e = 0;
		while (n / 2 != 0) {
			e++;
			n /= 2;
		}

		Div(N, 0, N, e);
		for (char[] arr : map) {
			for (char c : arr) {
				sb.append(c);
			}
			sb.append('\n');
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	static void Div(int N, int row, int col, int e) {
		if (N == 3) {
			map[row][col-1] = '*';
			map[row + 1][col - 2] = '*';
			map[row + 1][col] = '*';
			map[row + 2][col - 3] = '*';
			map[row + 2][col - 2] = '*';
			map[row + 2][col - 1] = '*';
			map[row + 2][col] = '*';
			map[row + 2][col + 1] = '*';
			return;
		}

		Div(N / 2, row, col, e-1);
		Div(N / 2, row + N/2, col-(N/2), e-1);
		Div(N / 2, row + N/2, col+(N/2), e-1);

	}
}
