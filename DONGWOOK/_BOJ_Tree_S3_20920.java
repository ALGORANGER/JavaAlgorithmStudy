package _02_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class _BOJ_Tree_S3_20920 {
	static Map<String, Integer> map = new HashMap<>();
	static Map<Integer, List<String>> newMap = new TreeMap<>(Collections.reverseOrder());
	static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");

		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);

		for (int n = 0; n < N; n++) {
			String word = br.readLine();
			if (word.length() >= M) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int val = entry.getValue();

			List<String> l = newMap.getOrDefault(val, new ArrayList<>());
			l.add(key);
			newMap.put(val, l);
		}

		for (Entry<Integer, List<String>> entry : newMap.entrySet()) {
			Collections.sort(entry.getValue(), new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(o2.length() == o1.length()) {
						return o1.compareTo(o2);
					}
					return o2.length() - o1.length();
				}
			});
			for(String word: entry.getValue()) {
				sb.append(word+"\n");
			}
		}
		System.out.println(sb.toString());
	}

}