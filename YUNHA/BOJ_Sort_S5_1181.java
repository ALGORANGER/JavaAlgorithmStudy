package com.ssafy.algo.day0203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_Sort_S5_1181 {
	
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		String [] string  = new String[N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			string[i] = str;
		} 
		
		Arrays.sort(string, (o1, o2) -> { 
			if(o1.length() == o2.length()) { 
				return o1.compareTo(o2);
			} else { 
				return Integer.compare(o1.length(),o2.length()); 
			} 
		});

		String current = string[0];
		bw.append(current + "\n");
		for(int i = 1; i < N; i++) {
			if(current.equals(string[i])) {
				continue;
			} else {
				current = string[i];
				bw.append(current + "\n");
			}
			bw.flush();
		}
		
		br.close();
		bw.close();
		
	}

}
