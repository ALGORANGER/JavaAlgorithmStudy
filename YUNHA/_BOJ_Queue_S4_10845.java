package com.ssafy.algo.day0127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _BOJ_Queue_S4_10845 {

	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();

		N = Integer.parseInt(br.readLine());
		int n = 0;
		
		while(N != 0) {
			String str = br.readLine();
			if(str.contains("pu")) {
				String[] s = str.split(" ");
				n = Integer.parseInt(s[1]);
				queue.offer(n);
			} else if(str.contains("po")) {
				if(queue.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(queue.poll());
				}
			} else if(str.contains("si")) {
				System.out.println(queue.size());
			} else if(str.contains("em")) {
				if(queue.isEmpty()) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} else if(str.contains("fr")) {
				if(queue.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(queue.peek());
				}
			} else if(str.contains("ba")) {
				if(queue.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(n);
				}
			}
			N--;
		}
		
	}

}
