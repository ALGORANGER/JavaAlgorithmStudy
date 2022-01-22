package practice;

import java.util.Scanner;

public class _BOJ_Simul_B3_2445 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();

		int n = 2 * num - 1;

		for (int i = 0; i < num -1; i++) {
			for(int j= 0 ; j<i+1; j++) {
				System.out.print("*");
			}
			for(int j= 0 ; j<2*(num-1-i); j++) {
				System.out.print(" ");
			}
			for(int j= 0 ; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
			
		for (int i = 0; i < 2*num; i++) {
			System.out.print("*");
		}
		
		System.out.println();
		
		for (int i = num; i < n; i++) {
			
			for(int j= 0 ; j< 2*num-i-1; j++) {
				System.out.print("*");
			}
			for(int j= 0 ; j< 2*(i-num+1); j++) {
				System.out.print(" ");
			}
			for(int j= 0 ; j< 2*num-i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
			System.out.println();
		}

	//배열 출력
}
