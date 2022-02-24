package com.ssafy.algo.day0222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _BOJ_String_G5_12904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String S = br.readLine();
		sb.append(br.readLine());

		while (sb.length() > S.length()) {
			if (sb.charAt(sb.length() - 1) == 'A') {
				sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.deleteCharAt(sb.length() - 1);
				sb.reverse();
			}
		}

		String T = sb.toString();

		if (T.equals(S)) {
			bw.append("1\n");
		} else {
			bw.append("0\n");
		}

		br.close();
		bw.flush();
		bw.close();

	}

}
