package com.ssafy.algo.day0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _BOJ_Stack_S3_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		int i = 0;
		boolean tag = false;
		
		String str = br.readLine();
		StringBuilder result = new StringBuilder();

		while(i < str.length()) {
			
			if(str.charAt(i) == '<') {
				tag = true;
				while(!stack.isEmpty()) {
					result.append(stack.pop());
				}
			}
			
			if(str.charAt(i) == '>') {
				result.append(str.charAt(i));
				tag = false;
			}
			
			if(tag == true) {
				result.append(str.charAt(i));
			} 
			
			if(tag == false) {
				if(str.charAt(i) == ' ') {
					while(!stack.isEmpty()) {
						result.append(stack.pop());
					}
					result.append(" ");
				} else if(str.charAt(i) != '>'){
					stack.push(Character.toString(str.charAt(i)));
				}
			}
						
			i++;
		}
		
		while(!stack.isEmpty()) {
			result.append(stack.pop());
		}
		
		System.out.println(result);
		
	}

}
