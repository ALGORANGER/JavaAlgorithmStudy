package com.ssafy.algo.day0210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.Map.Entry;

	 

public class _BOJ_Tree_S3_20920 {
	
	static class Word{
		int priority;
		String str;
		
		
		public Word(int priority, String str) {
			super();
			this.priority = priority;
			this.str = str;
		}
					
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		HashMap<String, Integer> hm = new HashMap<>();
		TreeSet<Word> word = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] str = new String[N];
		
		for(int i=0;i<N;i++) {
			String temp=br.readLine();
			if(temp.length()>=M) {
				if(!hm.containsKey(temp))
				hm.put(temp, 1);
				else {
					int a = hm.get(temp);
					hm.put(temp, a+1);
				}				
			}
		}
		
		
		
		
		
		System.out.println(word);
		

	}

}
