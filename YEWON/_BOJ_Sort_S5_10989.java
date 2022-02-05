package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _BOJ_Sort_S5_10989 { // 수 정렬하기 3 메모리가 너무 커...
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[] numbers = new int[T];

		for (int i = 0; i < T; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		} // 입력 완료

		Arrays.sort(numbers);

		for(int i = 0; i < T; i++) {
			answer.append(numbers[i]).append("\n");
		}

		System.out.println(answer);
		br.close();
	}

}
