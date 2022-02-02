package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _BOJ_Queue_S4_10845 {
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Queue<Integer> queue = new LinkedList<>();
			int t = Integer.parseInt(br.readLine());
			int last = 0;
			
			for(int i=0; i<t; i++) {
				String[] s = br.readLine().split(" ");
				if(s[0].equals("push")) {
					queue.add(Integer.parseInt(s[1]));
					last = Integer.parseInt(s[1]);
				}else if(s[0].equals("pop")) {
					if(!(queue.isEmpty())) {
						System.out.println(queue.poll());
					}else {
						System.out.println(-1);
					}
				}else if(s[0].equals("size")) {
					System.out.println(queue.size());
				}else if(s[0].equals("empty")){
					if(queue.isEmpty()) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
				}else if(s[0].equals("front")) {
					if(!(queue.isEmpty())) {
						System.out.println(queue.peek());
					}else {
						System.out.println(-1);
					}
				}else if(s[0].equals("back")) {
					if(!(queue.isEmpty())) {
						System.out.println(last);
					}else {
						System.out.println(-1);
					}
				}
		}

	}
}
