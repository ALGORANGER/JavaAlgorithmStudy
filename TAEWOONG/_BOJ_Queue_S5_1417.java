package com.ssafy.algo.day0120;

import java.util.Scanner;

public class _BOJ_Queue_S5_1417 {	
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N, count = 0;
		int dasom;
		
		
		
		N = Integer.parseInt(br.readLine());
		dasom= Integer.parseInt(br.readLine());

		boolean iswin = false;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N-1; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		if(N==1) iswin=true;
		
		while(!iswin && pq.peek()>=dasom) {
			int temp = pq.poll();
			pq.offer(temp-1);
			dasom++;
			count++;
		}
		
		System.out.println(count);
		
	}
		

}