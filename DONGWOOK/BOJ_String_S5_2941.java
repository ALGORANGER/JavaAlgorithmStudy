package _02_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_String_S5_2941 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {

			if (i == str.length() - 1) {
				count++;
				continue;
			}

			if ("cszln".indexOf(str.charAt(i)) >= 0) {

				int index = "cszln".indexOf(str.charAt(i));

				if (index <= 2 && "-=".indexOf(str.charAt(i + 1)) >= 0) {
					count++;
					i++;
					continue;
				}

				if (index > 2 && str.charAt(i + 1) == 'j') {
					count++;
					i++;
					continue;
				}
				count++;

			} else if (str.charAt(i) == 'd') {

				if (str.charAt(i + 1) == '-') {
					count++;
					i++;
					continue;
				}

				if (i <= str.length() - 3 && str.substring(i + 1, i + 3).equals("z=")) {
					i = i + 2;
					count++;
					continue;
				}
				count++;

			} else {
				count++;
			}

		}
		System.out.println(count);
	}

}
