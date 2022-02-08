package com.ssafy.algo.day0202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Sort_S5_11650 {

	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		int [][] point = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		} 
		
		Arrays.sort(point, (o1, o2) -> { 
			if(o1[0] == o2[0]) { 
				return Integer.compare(o1[1],o2[1]);
			} else { 
				return Integer.compare(o1[0],o2[0]); 
			} 
		});

		
		for(int i = 0; i < N; i++) {
			bw.append(point[i][0] + " " + point[i][1] + "\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
		
	}

}
