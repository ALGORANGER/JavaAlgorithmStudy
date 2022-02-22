package _02_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_String_G5_12904 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String answer = br.readLine();
		sb.append(br.readLine());
		while (sb.length() > answer.length()) {
			if (sb.charAt(sb.length() - 1) == 'A') {
				sb.setLength(sb.length() - 1);
			} else {
				sb.setLength(sb.length() - 1);
				sb.reverse();
			}
		}
		String end = sb.toString();
		if(end.equals(answer)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}
