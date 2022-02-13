package com.ssafy.algo.day0210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _BOJ_Tree_S4_1764 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt=0;
		
		HashSet<String> ear = new HashSet<>();
		HashSet<String> eye = new HashSet<>();
		TreeSet<String> Job = new TreeSet<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			ear.add(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			eye.add(st.nextToken());
		}
		
		Iterator<String> NotEye = eye.iterator();
		
		String temp;
		
		while(NotEye.hasNext()) {		
				if(ear.contains(temp=NotEye.next())){						
					cnt++;
					Job.add(temp);
				}						
		}
		
		bw.write(String.valueOf(cnt)+"\n");
		Iterator<String> answer = Job.iterator();
		while(answer.hasNext()) {
			bw.write(answer.next()+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		

	}

}
