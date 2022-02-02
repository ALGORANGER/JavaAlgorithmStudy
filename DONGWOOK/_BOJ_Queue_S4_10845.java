package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class _BOJ_Queue_S4_10845 {
	static List<Integer> list = new ArrayList<>();
	static int T;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = "";

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			str = br.readLine();
			arr = str.split(" ");

			char lastC = arr[0].charAt(arr[0].length() - 1);

			switch (lastC) {
			case 'h':
				list.add(Integer.parseInt(arr[1]));
				break;
			case 'p':
				if (list.size() == 0) {
					bw.write(-1 + "\n");
					break;
				} else {
					bw.write(list.get(0) + "\n");
					list.remove(0);
					break;
				}
			case 't':
				if (list.size() == 0) {
					bw.write(-1 + "\n");
					break;
				} else {
					bw.write(list.get(0) + "\n");
					break;
				}
			case 'k':
				if (list.size() == 0) {
					bw.write(-1 + "\n");
					break;
				} else {
					bw.write(list.get(list.size() - 1) + "\n");
					break;
				}
			case 'e':
				bw.write(list.size() + "\n");
				break;
			case 'y':
				if (list.size() == 0) {
					bw.write(1 + "\n");
					break;
				} else {
					bw.write(0 + "\n");
					break;
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
