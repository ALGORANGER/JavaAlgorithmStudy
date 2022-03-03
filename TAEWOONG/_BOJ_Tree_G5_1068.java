package com.ssafy.algo.day2024;

import java.io.*;
import java.util.*;

public class _BOJ_Tree_G5_1068 {
	
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int root = 0;

		LinkedList<Integer> ll = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			ll.add(Integer.parseInt(st.nextToken()));
			if (ll.get(i) == -1) {
				root = i;
			}
		}

		//

		int M = Integer.parseInt(br.readLine());
		ll.set(M, -100);

		
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (ll.get(i)!=-1 && ll.get(i)!=-100 && ll.get(ll.get(i)) == -100) {
					ll.set(i,-100);
				}
			}
		}
		//System.out.println((ll.toString()));
		
		boolean[] isReaf = new boolean[N];
		
		for(int i=0;i<N;i++) {
			if(ll.get(i)==-1) {
			}else if(ll.get(i)==-100) {
				isReaf[i]=true;
			}else {
				isReaf[ll.get(i)] = true;
			}
			
		}
		
		for(int i=0;i<N;i++) {
			if(!isReaf[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
