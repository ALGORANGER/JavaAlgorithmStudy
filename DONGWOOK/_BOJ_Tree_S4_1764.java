package _02_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry; //Entry 쓸거면 이거 임포트 해야 됨
import java.util.Set;
import java.util.TreeSet;

public class _BOJ_Tree_S4_1764 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Map<String, Integer> map = new HashMap<>();
	static Set<String> set = new TreeSet<>();

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new StringReader(src));
		String[] arr = br.readLine().split(" ");
		int total = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
		int cnt= 0;
		for (int t = 0; t < total; t++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue()==2) {
				set.add(entry.getKey());
				cnt++;
			}
		}
		sb.append(cnt+"\n");
		for(String s : set) {
			sb.append(s+"\n");
		}
		System.out.println(sb.toString());
	}

	static String src = "3 4\r\n" + "ohhenrie\r\n" + "charlie\r\n" + "baesangwook\r\n" + "obama\r\n" + "baesangwook\r\n"
			+ "ohhenrie\r\n" + "clinton";

}
