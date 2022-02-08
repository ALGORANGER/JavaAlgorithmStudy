package com.ssafy.algo.day0202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _BOJ_Sort_S3_1931 {
	
	static class time{
		int first;
		int last;
		
		public time(int first, int last) {
			this.first = first;
			this.last = last;
		}

		@Override
		public String toString() {
			return first + " " +last ;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N= Integer.parseInt(br.readLine());
		time[] t = new time[N];
		String[] str ;
		for(int i=0;i<N;i++) {
			str = br.readLine().split(" ");
			t[i]= new time(Integer.parseInt(str[0]), Integer.parseInt(str[1]));	
		}
		
		Arrays.sort(t, new Comparator<time>() {
			
			@Override
			public int compare(time o1, time o2) {
				if(o1.last == o2.last) {
					return o1.first - o2.first;
				}else
					return o1.last - o2.last;
			}
		});
		
		int cnt =0;
		int end =0;
		for(int i=0;i<N;i++) {
			if(end<=t[i].first) {
				cnt++;
				end=t[i].last;
			}
		}
		
		bw.write(String.valueOf(cnt));
		
		bw.flush();
		bw.close();
		
		

	}

}
