package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_5525_IOIOI {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int N, M;
	private static String S, P;
	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());  // N
		M = Integer.parseInt(br.readLine());  // S의 길이
		S = br.readLine();                    // S
		P = "";
		int cnt = 0;
		
		for(int i = 0; i <N; i++) {
			P += "IO";
		}
		
		System.out.println(P);
		for(int i = 0; i < M-P.length(); i++) {
			if(S.charAt(i) == 'I') {
				if(S.substring(i, i+P.length()).equals(P)) {
					cnt++;
					i += 2;
				}else {
					continue;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
