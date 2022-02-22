package com.ssafy.algo.day0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _BOJ_String_S5_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] alpha = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String str = br.readLine();

		for (int i = 0; i < alpha.length; i++) {
			if (str.contains(alpha[i])) {
				str = str.replace(alpha[i], ".");
			}
		}

		bw.append(str.length() + "\n");

		br.close();
		bw.flush();
		bw.close();

	}

}
