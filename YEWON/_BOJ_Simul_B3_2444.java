package com.ssafy.algo.day0120;

import java.util.Scanner;

public class _BOJ_Simul_B3_2444 {
	
	static int N;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			for(int j = N - 1; j > i; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i * 2 + 1; k++) {
				System.out.print("*");
			}	
			System.out.println();
		}
		
		for(int i = N - 1; i > 0; i--) {
			for(int j = i; j < N; j++) {
				System.out.print(" ");
			}
			for(int k = i * 2; k > 1; k--) {
				System.out.print("*");
			}	
			System.out.println();
		}
	
		sc.close();
	}

}