package _02_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class _BOJ_Tree_S1_4358 {
	static Map<String, Integer> map = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		String str = "";
		int total = 0;
		while ((str = br.readLine()) != null) {
			map.put(str, map.getOrDefault(str, 0) + 1);
			total++;
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			sb.append(String.format("%s %.4f\n",entry.getKey(),(double) entry.getValue()/total*100));
		}
		System.out.println(sb.toString());
	}

	static String src = "Red Alder\r\n" + "Ash\r\n" + "Aspen\r\n" + "Basswood\r\n" + "Ash\r\n" + "Beech\r\n"
			+ "Yellow Birch\r\n" + "Ash\r\n" + "Cherry\r\n" + "Cottonwood\r\n" + "Ash\r\n" + "Cypress\r\n"
			+ "Red Elm\r\n" + "Gum\r\n" + "Hackberry\r\n" + "White Oak\r\n" + "Hickory\r\n" + "Pecan\r\n"
			+ "Hard Maple\r\n" + "White Oak\r\n" + "Soft Maple\r\n" + "Red Oak\r\n" + "Red Oak\r\n" + "White Oak\r\n"
			+ "Poplan\r\n" + "Sassafras\r\n" + "Sycamore\r\n" + "Black Walnut\r\n" + "Willow";
}
