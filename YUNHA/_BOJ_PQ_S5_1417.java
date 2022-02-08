package com.ssafy.algo.day0129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _BOJ_PQ_S5_1417 {
	
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
		N = Integer.parseInt(br.readLine());
		
		if(N > 50)
			return;

		int ds = Integer.parseInt(br.readLine());
		if(ds > 100)
			return;
		
		int cnt = 0;
		
		for(int i = 1; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n > 100)
				return;
			pq.offer(n);
		}
		
		while(pq.peek() != null) {
			int p = pq.poll();
			if(p < ds)
				break;
			else {
				cnt++;
				ds++;
				pq.add(--p);
			}
		}
		
		System.out.println(cnt);
		br.close();
		
	}

}
