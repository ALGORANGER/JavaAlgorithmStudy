package com.ssafy.algo.day0202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class _BOJ_Sort_S5_10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N= Integer.parseInt(br.readLine());
		
		//int[] arr = new int[N];                 //단순 정렬
		int[] num = new int[10001];               //카운팅 기법
		
		for(int i=0;i<N;i++) {
			num[Integer.parseInt(br.readLine())]++;			
		}
		//Arrays.sort(arr);
		
		/*for(int i=0;i<N;i++) {
			bw.write(arr[i]+"\n");
		}*/
		
		
		for(int i=1;i<10001;i++) {
			while(num[i]>0) {
				bw.write(i+"\n");
				num[i]--;
			}
		}
		
		bw.flush();
		bw.close();
		

	}

}
