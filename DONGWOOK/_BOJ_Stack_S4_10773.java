package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _BOJ_Stack_S4_10773 {
	static Stack<Integer> stack = new Stack<>();
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				stack.pop();
			}else {
				stack.push(num);
			}
		}
		
		int total = 0;
		
		while(!stack.isEmpty()) {
			total += stack.pop();
		}
		
		bw.write(total+"");
		bw.flush();
		bw.close();
	}
}
