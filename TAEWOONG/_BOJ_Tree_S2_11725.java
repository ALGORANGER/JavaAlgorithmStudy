package com.ssafy.algo.day2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _BOJ_Tree_S2_11725 {
	
	static int N;
	static ArrayList<Integer>[] arl;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		//이진트리 가 아니라서 기존에 하던거 다 버리고 arrayList 이용
		arl = new ArrayList[N+1];	
		for(int i=0;i<N+1;i++) {
			arl[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arl[a].add(b);
			arl[b].add(a);  // a와b는 서로 연결되어있다. 
		}
		
		//a,b중 누가 누구의 부모인가?
		int root[] = new int[N+1];
		dfs(root,1,0); //어차피 1의 부모는 없으므로 아무거나 줘도됨 1~100000 사이만 아니면
		
		for(int i=2;i<=N;i++) {
			System.out.println(root[i]);
		}


	}
	
	static void dfs(int[] root,int cnt,int rootV) {
		root[cnt] = rootV;
		for(int i : arl[cnt]) {
			if(i!=rootV) {
				dfs(root,i,cnt);
			}
		}
	}
	
	

}
