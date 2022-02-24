package com.ssafy.algo.day0222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _BOJ_String_S2_5525 {

	private static int result = 0;
	private static int N, M;
	private static String S;

	public static int[] getPi(String pattern) { // 접두사와 접미사 매칭 Count
		int LenOfPattern = pattern.length(); // 찾을 Pattern's Length
		int[] pi = new int[LenOfPattern]; // pi[] 할당
		int j = 0; // 패턴을 탐색할 인덱스

		for (int i = 1; i < LenOfPattern; i++) { // i = 1부터
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) { // KMP알고리즘, 매칭되는 것 건너뛴다
				j = pi[j - 1]; // j를 재할당 (건너 뜀)
			}
			if (pattern.charAt(i) == pattern.charAt(j)) { // 접두사랑 접미사가 같다면
				pi[i] = ++j; // 해당 인덱스 카운트 (길이)
			}
		}
		return pi; // pi[] 반환
	}

	public static int KMP(String str, String pattern) { // 매칭되는 str을 ArrayList에 저장

		ArrayList<Integer> list = new ArrayList<>(); // 매칭된 str을 저장할 ArrayList
		int[] pi = getPi(pattern); // 찾을 패턴의 접두사와 접미사가 카운트된 배열 불러온다
		int LenOfStr = str.length(); // 원본 str의 길이
		int LenOfPattern = pattern.length(); // 찾을 pattern의 길이
		int j = 0; // pattern을 탐색시킬 인덱스

		for (int i = 0; i < LenOfStr; i++) { // str의 0번째 (가장 처음부터) 탐색
			while (j > 0 && str.charAt(i) != pattern.charAt(j)) { // KMP 알고리즘의 핵심
				j = pi[j - 1]; // j 재할당 (건너 뛴다)
			}
			if (str.charAt(i) == pattern.charAt(j)) { // 문자가 같을 때
				if (j == LenOfPattern - 1) { // 해당 인덱스가 패턴의 끝과 일치? 그럼 매칭 성공!
					list.add(i - LenOfPattern + 1); // 찾은 패턴을 list에 순서대로 넣는다
					j = pi[j]; // j 초기화
				} else { // 해당 인덱스가 패턴의 끝과 일치하지 않으면 더 찾아야 함!
					j++; // 탐색 인덱스 증가!
				}
			}
		}
		if (list.size() > 0)
			return list.size();
		else
			return 0;// 매칭된 패턴이 저장된 list 반환
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append("IOI");

		for (int n = 1; n < N; n++) {
			sb.append("OI");
		}

		result = KMP(S, sb.toString());

		bw.append(result + "\n");

		br.close();
		bw.flush();
		bw.close();

	}

}