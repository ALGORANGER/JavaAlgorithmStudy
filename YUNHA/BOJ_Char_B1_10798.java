package com.ssafy.algo.day0121;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Char_B1_10798 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[][] string = new char[5][15];
		
		for(int t = 0; t < 5; t++) {
			String str = sc.next();
			while(str.length() != 15) {
				str += " ";
			}
			char[] ch = str.toCharArray();
			string[t] = ch;
		}
		
		char[] temp = new char[5 * 15];
		int idx = 0;

		for(int r = 0; r < 15; r++) {
			for(int c = 0; c < 5; c++) {
				if(string[c][r] != ' ') {
					temp[idx++] = string[c][r];
				}
			}
		}

		for(int i = 0; i < idx; i++) {
				System.out.print(temp[i]);
		}
		
	}

}
