package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class _BOJ_Queue_S5_1417 {

	static PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int me = Integer.parseInt(br.readLine());
		int count = 0;
		for (int n = 0; n < N-1; n++) {
			PQ.offer(Integer.parseInt(br.readLine()));
		}
		if (PQ.isEmpty()) {
			bw.write(0 + "");
		} else {
			while (me <= PQ.peek()) {
				int num = PQ.poll() - 1;
				PQ.offer(num);
				count++;
				me++;
			}
			bw.write(count+"");
		}
		
		bw.flush();
		bw.close();
	}
}
