package com.ssafy.algo.day0129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _BOJ_Queue_S1_13335 {

	private static int N, W, L;	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		int tmpL = 0;
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		W = Integer.parseInt(str[1]);
		L = Integer.parseInt(str[2]);

		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> t = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			t.offer(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < W; i++) {
			q.offer(0);
		}
		
		while(!q.isEmpty()) {	
			tmpL -= q.poll();
			if(!t.isEmpty()) {
				if(t.peek() + tmpL <= L) {
					q.offer(t.peek());
					tmpL += t.poll();
				} else {
					q.offer(0);
				}
			}
			cnt++;	
		}	
	
		System.out.println(cnt);	
		
	}

}
