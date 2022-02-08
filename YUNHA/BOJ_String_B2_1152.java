package com.ssafy.algo.day0122;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_String_B2_1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		System.out.println(st.countTokens());
		
		sc.close();
	}

}
