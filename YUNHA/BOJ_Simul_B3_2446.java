package com.ssafy.algo.day0121;

import java.util.Scanner;

public class BOJ_Simul_B3_2446 {

	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = 2 * N - (i * 2) - 1; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = N - 1; i > 0; i--) {
			for(int j = i - 1; j > 0; j--) {
				System.out.print(" ");
			}
			for(int k = 0; k < 2 * (N - i) + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
		
	}

}
