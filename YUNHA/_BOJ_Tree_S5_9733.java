package com.ssafy.algo.day0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class _BOJ_Tree_S5_9733 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		TreeMap<String, Integer> honeyBee = new TreeMap<String, Integer>(){{
			put("Re", 0);
			put("Pt", 0);
			put("Cc", 0);
			put("Ea", 0);
			put("Tb", 0);
			put("Cm", 0);
			put("Ex", 0);
		}};
		
		int todo = 0;
		String[] tasks = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
		String input = "";
		
		while(todo < 24 && (input = br.readLine()) != null) {
			String [] str = input.split(" ");			
			todo += str.length;
			for(int s = 0; s < str.length; s++) {
				switch(str[s]) {
					case "Re":
						honeyBee.put(str[s], honeyBee.get(str[s])+1);
						break;
					case "Pt":
						honeyBee.put(str[s], honeyBee.get(str[s])+1);
						break;
					case "Cc":
						honeyBee.put(str[s], honeyBee.get(str[s])+1);
						break;
					case "Ea":
						honeyBee.put(str[s], honeyBee.get(str[s])+1);
						break;
					case "Tb":
						honeyBee.put(str[s], honeyBee.get(str[s])+1);
						break;
					case "Cm":
						honeyBee.put(str[s], honeyBee.get(str[s])+1);
						break;
					case "Ex":
						honeyBee.put(str[s], honeyBee.get(str[s])+1);
						break;
				}
			}
		}
		
		for (int t = 0; t < tasks.length; t++) {
		    bw.append(tasks[t] + " " + honeyBee.get(tasks[t]) + String.format(" %.2f\n", (double)honeyBee.get(tasks[t])/todo));
		}
		bw.append("Total " + todo + " 1.00\n");
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
