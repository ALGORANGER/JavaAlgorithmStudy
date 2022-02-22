package _02_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _BOJ_Tree_S5_9733 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] arr = { "Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex" };
	static int total;
	static Map<String, Integer> map = new TreeMap<>();

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		String str = "";

		while ((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				map.put(s, map.getOrDefault(s, 0) + 1);
				total++;
			}
		}
		sb = new StringBuilder();
		for (String s : arr) {
			int c = map.getOrDefault(s,0);
			double rate = (double)Math.round((double)c/total * 100) / 100;
			System.out.printf("%s %d %.2f\n",s,c,rate);
		}
		System.out.printf("Total %d %.2f", total, (double)total/total);
	}
	static String src = "Cc Pt Pt Re Tb Re Cm Cm Re Pt Pt Re Ea Ea Pt Pt\r\n" + "Pt Re Re Cb Cb Pt Pt Cb";
}
