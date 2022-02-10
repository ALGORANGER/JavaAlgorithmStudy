package com.ssafy.algo.day0210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _BOJ_Tree_S1_4358 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);

		String str;
		int total = 0;
		boolean isReplace = false;

		TreeMap<String, Integer> tree = new TreeMap<>();

		while ((str = br.readLine()) != null) {
			/*if (tree.isEmpty()) {
				tree.put(str, 1);
				continue;
			}*/
			// System.out.println(str);
			
			if(tree.containsKey(str)) {      // TreeMap.get(Key) = Key값에 매칭되는 Value를 가져옴
				int e = tree.get(str);
				tree.replace(str, e + 1);
				isReplace = true;
			}else {
				tree.put(str,1);
			}
			// break;

			// System.out.println(tree.size());
			if (!isReplace) {
				tree.put(str, 1);
			}

			isReplace = false;
			total++;

		}

		for (Entry<String, Integer> e : tree.entrySet()) {
			String s = String.format("%.4f", ((float) e.getValue() / total) * 10000 / 100);
			bw.write(e.getKey() + " " + s + "\n");
		}

		sc.close();
		bw.close();

	}
}
