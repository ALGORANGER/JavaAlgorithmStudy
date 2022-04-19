package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_DP_S1_16456 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		long[] memo = new long[50001];
		
		int N = Integer.parseInt(br.readLine());
		
		memo[1]=1; //1,1,2,3,4,6
		memo[2]=1;
		memo[3]=2;
		
		for(int i=4;i<50001;i++) {
			memo[i] = memo[i-2]*2 %1000000009;
		}
		
		System.out.println(memo[N]);
		

	}

}
