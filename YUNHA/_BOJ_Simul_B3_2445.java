package com.ssafy.algo.day0120;

import java.util.Scanner;

public class _BOJ_Simul_B3_2445 {

	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		for(int i = 1; i <= N; i++) {

			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			for(int j = (N - i) * 2; j > 0; j--) { 
				System.out.print(" ");
			}
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for(int i = 1; i < N; i++) {

			for(int j = N; j > i; j--) {
				System.out.print("*");
			}
			for(int j = i * 2; j > 0; j--) { // 4, 1
				System.out.print(" ");
			}
			for(int j = N; j > i; j--) {
				System.out.print("*");
			}
			
			System.out.println();
		}
			
		sc.close();
	}
}
