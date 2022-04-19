package _04_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class CS {
	int day;
	int pay;

	public CS(int day, int pay) {
		this.day = day;
		this.pay = pay;
	}

}

public class BOJ_DP_S3_14501 {
	static int N, answer = Integer.MIN_VALUE;
	static List<CS> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list.add(new CS(0,0));
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new CS(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		DFS(1, 0);
		System.out.println(answer);
	}

	static void DFS(int day, int sum) {
		if (day > N) {
			answer = answer < sum ? sum : answer;
			return;
		}

		CS cs = list.get(day);
		
		if (day + cs.day-1 <= N) {
			DFS(day + cs.day, sum + cs.pay);
		}
		
		DFS(day + 1, sum);

	}
}