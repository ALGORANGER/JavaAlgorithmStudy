package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class room implements Comparable<room> {
	int start;
	int end;
	int time;

	room(int start, int end) {
		this.start = start;
		this.end = end;
		this.time = end - start;
	}

	@Override
	public int compareTo(room o) {
		if (this.start == o.start) {
			return Integer.compare(this.time, o.time);
		} else {
			return Integer.compare(this.start, o.start);
		}
	}

}

public class _BOJ_Sort_S2_1931 {
	
	static PriorityQueue<room> PQ = new PriorityQueue<>();
	static int answer = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			String[] arr = br.readLine().split(" ");
			room r = new room(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
			PQ.offer(r);
		}
		
		room cur = PQ.poll();
		while(!PQ.isEmpty()) {
			if(PQ.peek().end < cur.end) {
				cur = PQ.poll();
			}else {
				if(PQ.peek().start >= cur.end) {
					answer ++;
					cur = PQ.poll();
				}else {
					PQ.poll();
				}
			}
		}
		answer++;
		System.out.println(answer);
	}
	
}
