package com.ssafy.algo.day0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _BOJ_Sort_S2_1931 {

	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int [][] arr = new int[N][2];
		int cnt = 0;
		
		for(int n = 0; n < N; n++) {
			String[] str = br.readLine().split(" ");
			
			arr[n][0] = Integer.parseInt(str[0]);
			arr[n][1] = Integer.parseInt(str[1]);	
			
		}
		
		Arrays.sort(arr, (o1, o2) -> { 
			if(o1[1] == o2[1]) { 
				return Integer.compare(o1[0],o2[0]);
			} else { 
				return Integer.compare(o1[1],o2[1]); 
			} 
		});
		
		int endTime = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i][0] < endTime) {
				continue;
			} else {
				endTime = arr[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
		br.close();

	}

}
