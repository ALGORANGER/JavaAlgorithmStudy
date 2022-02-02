package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

class block implements Comparable<block>{
	int element;
	boolean isDeleted;
	
	public block(int element) {
		this.element = element;
		this.isDeleted  = false;
	}
	
	@Override
	public int compareTo(block o) {
		return this.element - o.element;
	}
}

public class _BOJ_Queue_G5_7662 {
	
	static PriorityQueue<block> PQ = new PriorityQueue<>();
	static PriorityQueue<block> RPQ = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		String[] arr = new String[2];

		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine());
			for (int n = 0; n < N; n++) {

				arr = br.readLine().split(" ");
				int num = Integer.parseInt(arr[1]);
				
				if (arr[0].equals("I")) {
					
					block b = new block(num);
					PQ.offer(b);
					RPQ.offer(b);
					
				}else if(arr[0].equals("D")){
					
					if(num == 1) {
						
						while(!RPQ.isEmpty() && RPQ.peek().isDeleted) {
							RPQ.poll();
						}
						
						if(!RPQ.isEmpty()) {
							block b = RPQ.poll();
							b.isDeleted = true;
						}
						
					}else if(num == -1){
						
						while(!PQ.isEmpty() && PQ.peek().isDeleted) {
							PQ.poll();
						}
						
						if(!PQ.isEmpty()) {
							block b = PQ.poll();
							b.isDeleted = true;
						}
					}
				}
			}
			
			while(!RPQ.isEmpty() && RPQ.peek().isDeleted) {
				RPQ.poll();
			}
			
			while(!PQ.isEmpty() && PQ.peek().isDeleted) {
				PQ.poll();
			}
			
			if(PQ.size() + RPQ.size() == 0) {
				bw.write("EMPTY\n");
			}else {
				int max = RPQ.poll().element;
				int min = PQ.poll().element;
				
				bw.write(max+" "+min+"\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
