package com.ssafy.algo.day0222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _BOJ_String_S4_1120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");
		String a = str[0];
		String b = str[1];
		int min = Integer.MAX_VALUE;
		int idx = 0;

		do {
			int cnt = 0;
			char[] ba = b.substring(idx, a.length() + idx).toCharArray();
			char[] aa = a.toCharArray();

			for (int j = 0; j < a.length(); j++) {
				if (aa[j] != ba[j]) {
					cnt++;
				}
			}

			min = Math.min(min, cnt);
			idx++;
		} while (idx <= b.length() - a.length());

		bw.append(min + "\n");

		br.close();
		bw.flush();
		bw.close();

	}

}
