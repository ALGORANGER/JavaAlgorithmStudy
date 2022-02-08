package com.ssafy.algo.day0204;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _BOJ_Sort_S5_10989 {

	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		int [] arr = new int [N];
		
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int a: arr) {
			bw.append(a + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
