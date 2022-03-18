package com.ssafy.algo.day0310;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _BOJ_DFS_S2_2210 {
	
	static int cnt,map[][] = new int[5][5];
	static StringBuilder sb = new StringBuilder();;
	static ArrayList<String> arl = new ArrayList<>();
	static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static HashSet<String> hs = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;	
		
		for(int r=0;r<5;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<5;c++) {
				
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {

				bfs(r,c);
			}
		}
		//System.out.println(arl);
		System.out.println(hs.size());
	}
	
	static void bfs(int r,int c) {
		
		if(sb.length()==6) {
			
			hs.add(sb.toString())	;						
			return;
			
		}
		
		sb.append(map[r][c]);
		
		for(int d=0;d<4;d++) {
			int nr=r+deltas[d][0];
			int nc=c+deltas[d][1];
			
			if(nr>=0 && nc>=0 && nr<5 && nc<5) {
				bfs(nr,nc);
				
			}
		}
		
		sb.setLength(sb.length()-1);
		
		
	}

}
