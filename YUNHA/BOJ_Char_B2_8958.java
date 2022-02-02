package com.ssafy.algo.day0121;

import java.util.Scanner;

public class BOJ_Char_B2_8958 {
	
	private static int T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = Integer.parseInt(sc.nextLine());
		
		for(int t = 0; t < T; t++) {
			int count = 0;
			int sum = 0;
			
			char[] chars = sc.nextLine().toCharArray();
			for(char ch: chars) {
				if(ch == 'O') {
					sum += ++count;
				} else {
					count = 0;
				}
			}
			System.out.println(sum);
		}
		
		sc.close();
		
	}

}
