package com.ssafy.algo.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Comb_S3_15650 {

	private static int N, M;
	private static int[] numbers;
	private static int [] inputs;
	
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int n: numbers) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		} 
		
		for(int n = start; n < N; n++) {
			numbers[cnt] = inputs[n];
			combination(cnt + 1, n + 1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		inputs = new int[N];
		numbers = new int[M];

		for(int n = 0; n < N; n++) {
			inputs[n] = n + 1;
		}     
		
		combination(0, 0);
		
		br.close();

	}

}