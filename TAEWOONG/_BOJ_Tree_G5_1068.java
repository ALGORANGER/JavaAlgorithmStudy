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
			ll.add(Integer.parseInt(st.nextToken()));  //리스트에 하나하나 넣어줍니다
			if (ll.get(i) == -1) {
				root = i;   //-1이면 얘가 루트
			}
		}

		//

		int M = Integer.parseInt(br.readLine());
		ll.set(M, -100);   // 제외할 놈은 먼저 -100으로

		
		for (int j = 0; j < N; j++) {    //최악의 최악의 경우 N*N 50이라 괜찮다
			for (int i = 0; i < N; i++) {
				if (ll.get(i)!=-1 && ll.get(i)!=-100 && ll.get(ll.get(i)) == -100) {  
					ll.set(i,-100); //지워진 노드의 자식노드를 전부 -100으로
				}
			}
		}
		//System.out.println((ll.toString()));
		
		boolean[] isReaf = new boolean[N];  //리프인지 판별하는 배열
		
		for(int i=0;i<N;i++) {
			if(ll.get(i)==-1) {
			}else if(ll.get(i)==-100) {
				isReaf[i]=true;   //-100은 제외 노드므로 리프일리 X
			}else {
				isReaf[ll.get(i)] = true; //누군가 나를 부모로 하고있으면
			}
			
		}
		
		for(int i=0;i<N;i++) {
			if(!isReaf[i]) {   //누군가 나를 부모로 하지 않는 노드이면
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
