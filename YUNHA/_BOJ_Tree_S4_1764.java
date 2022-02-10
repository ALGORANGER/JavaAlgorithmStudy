package com.ssafy.algo.day0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.TreeMap;

public class _BOJ_Tree_S4_1764 {
	
	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] str = br.readLine().split(" ");			
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		TreeMap<String, Integer> people = new TreeMap<String, Integer>();
		String input = "";
		int cnt = 0;
		
		for(int n = 0; n < N; n++) {
			people.put(br.readLine(), 1);
		}
		
		for(int m = 0; m < M; m++) {
			input = br.readLine();
			if(people.containsKey(input)) {
				cnt++;
				people.put(input, 2);
			} else {
				people.put(input, 1);
			}
		}
		
		Iterator<String> keys = people.keySet().iterator();
		
		bw.append(cnt + "\n");
		while(keys.hasNext()){
		    String key = keys.next();
		    if(people.get(key) == 2) {
		    	bw.append(key + "\n");
		    }
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
