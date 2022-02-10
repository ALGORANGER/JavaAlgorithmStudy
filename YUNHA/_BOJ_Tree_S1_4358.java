package com.ssafy.algo.day0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.TreeMap;

public class _BOJ_Tree_S1_4358 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		TreeMap<String, Integer> tree = new TreeMap<String, Integer>();
		
		int cnt = 0;
		String input = "";
		
		while((input = br.readLine()) != null) {
			cnt++;
			if(tree.containsKey(input)) {
				tree.put(input, tree.get(input)+1);
			} else {
				tree.put(input, 1);
			}
		}
		
		Iterator<String> keys = tree.keySet().iterator();
		
		while(keys.hasNext()){
		    String key = keys.next();
		    bw.append(key + String.format(" %.4f\n", (double)tree.get(key)/cnt*100));
		    
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
