package practice;

import java.util.Scanner;

public class _BOJ_Simul_B3_2444 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();

		int n = 2 * num - 1;

		for (int i = 0; i < n; i++) {
			if (i <= num - 1) {
				for (int j = num - 1 - i; j > 0; j--) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2 * i + 1; j++) {

					System.out.print("*");
				}
			} else if (i > num - 1) {
				for (int j = i - num +1; j > 0; j--) {
					System.out.print(" ");
				}
				for (int j = 2 * n - 1 - 2 * i; j > 0; j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
/*
 * 0 1 1 3 2 5 3 7 4 9 5 7 6 5 7 3 8 1
 */