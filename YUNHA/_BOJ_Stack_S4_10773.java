package com.ssafy.algo.day0127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _BOJ_Stack_S4_10773 {

	private static int K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		
		K = Integer.parseInt(br.readLine());
		
		if(K < 0 || K > 1000000) {
			return;
		}
		
		for(int t = 0; t < K; t++) {
			int n = Integer.parseInt(br.readLine());			
			if(n < 0 || n > 1000000) {
				return;
			}			
			if(n != 0) { 
				stack.push(n);
			} else {
				stack.pop();
			}
		}
		
		for(int i = stack.size(); i > 0; i--) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
		
	}

}
