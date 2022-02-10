package algorithm.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _BOJ_Tree_S5_9733 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;

	private static int TotalCnt;

	public static void main(String[] args) throws IOException {
		// delete
		System.setIn(_BOJ_Tree_S5_9733.class.getResourceAsStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		// delete

		
		TreeMap<String, Integer> bee = new TreeMap<String, Integer>() {
			{
				put("Re", 0);
				put("Pt", 0);
				put("Cc", 0);
				put("Ea", 0);
				put("Tb", 0);
				put("Cm", 0);
				put("Ex", 0);
			}
		};
		TotalCnt = 0;
		while (br.ready()) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				switch (st.nextToken()) {
				case "Cc":
					bee.put("Cc", bee.get("Cc") + 1);
					TotalCnt++;
					break;
				case "Pt":
					bee.put("Pt", bee.get("Pt") + 1);
					TotalCnt++;
					break;
				case "Re":
					bee.put("Re", bee.get("Re") + 1);
					TotalCnt++;
					break;
				case "Ea":
					bee.put("Ea", bee.get("Ea") + 1);
					TotalCnt++;
					break;
				case "Tb":
					bee.put("Tb", bee.get("Tb") + 1);
					TotalCnt++;
					break;
				case "Cm":
					bee.put("Cm", bee.get("Cm") + 1);
					TotalCnt++;
					break;
				case "Ex":
					bee.put("Ex", bee.get("Ex") + 1);
					TotalCnt++;
					break;
				default:
					TotalCnt++;
					break;
				}
			}
		
		}

		System.out.printf("%s %d %.2f%n", "Re", bee.get("Re"), (float)bee.get("Re") / TotalCnt);
		System.out.printf("%s %d %.2f%n", "Pt", bee.get("Pt"), (float)bee.get("Pt") / TotalCnt);		
		System.out.printf("%s %d %.2f%n", "Cc", bee.get("Cc"), (float)bee.get("Cc") / TotalCnt);	
		System.out.printf("%s %d %.2f%n", "Ea", bee.get("Ea"), (float)bee.get("Ea") / TotalCnt);		
		System.out.printf("%s %d %.2f%n", "Tb", bee.get("Tb"), (float)bee.get("Tb") / TotalCnt);	
		System.out.printf("%s %d %.2f%n", "Cm", bee.get("Cm"), (float)bee.get("Cm") / TotalCnt);
		System.out.printf("%s %d %.2f%n", "Ex", bee.get("Ex"), (float)bee.get("Ex") / TotalCnt);
		System.out.printf("%s %d %.2f%n", "Total", TotalCnt, (float)1);

	}

}
