package com.ssafy.algo.day0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class _BOJ_Tree_S3_20920 {
	
	private static int N, M;
	
	public static class Dict implements Comparable <Dict>{
		String word;
		int cnt;
		
		public Dict(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}
		
		@Override
	    public int compareTo(Dict o) {
	        if(cnt != o.cnt)
	            return Integer.compare(o.cnt, cnt);
	        else if(word.length() != o.word.length())
	            return Integer.compare(o.word.length(), word.length());
	        else
	            return word.compareTo(o.word);
	    }
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] str = br.readLine().split(" ");			
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		TreeSet<Dict> dict = new TreeSet<Dict>();
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		String input = "";
		
		for(int n = 0; n < N; n++) {
			input = br.readLine();
			
			if(input.length() < M) {
				continue;
			}
			
			if(count.containsKey(input)) {
				count.put(input, count.get(input)+1);
			} else {
				count.put(input, 1);
			}

		}
		
		Iterator<String> keys = count.keySet().iterator();
		
		while(keys.hasNext()){
		    String key = keys.next();
		    dict.add(new Dict(key, count.get(key).intValue()));
		}
		
		dict.comparator();
		
		for(Dict d: dict) {
			bw.append(d.word + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
