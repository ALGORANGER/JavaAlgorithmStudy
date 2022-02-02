package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class _BOJ_Queue_S4_10773 {
	public static void main(String[] args) {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
		Scanner scan = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int t = scan.nextInt();
		
		
		for (int i = 0; i < t; i++) {
			int number = scan.nextInt();
			if (number != 0) {
				stack.push(number);
			} else if (number == 0) {
				stack.pop();
			}
		}
		int answer = 0;
		while(!stack.isEmpty()){
			answer += stack.peek();
			stack.pop();
		}
		
		System.out.println(answer);
		
	}
}
