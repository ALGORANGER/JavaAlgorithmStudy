package com.ssafy.algo.day0310;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _BOJ_DFS_S2_2529 {
	static int N;
	static boolean[] check;
	static String str[];
	static ArrayList<String> arl = new ArrayList<>();
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;	
		
		
		N = Integer.parseInt(br.readLine());
		
		str = new String[N];
		check = new boolean[10];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			str[i]=st.nextToken();
		}
		////여기까지 입력
		
		sb = new StringBuilder();
		//System.out.println(Arrays.toString(str));
		
		bfs(0);
		
		Collections.sort(arl);
		
		//System.out.println(arl);
		System.out.println(arl.get(arl.size()-1)+"\n"+arl.get(0));
		
		
		

	}
	
	static void bfs(int cnt) {
		if(cnt==N+1) {
			arl.add(sb.toString());
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(cnt==0) {
				check[i]=true;
				sb.append(i);
				bfs(cnt+1);
				check[i]=false;
				sb.setLength(sb.length()-1);
			}else if(str[cnt-1].equals(">") && !check[i]) {
				if(sb.charAt(cnt-1)-'0'>i) {
					check[i]=true;
					sb.append(i);
					bfs(cnt+1);
					check[i]=false;
					sb.setLength(sb.length()-1);
				}
			}else if(str[cnt-1].equals("<") && !check[i]) {
				if(sb.charAt(cnt-1)-'0'<i) {
					check[i]=true;
					sb.append(i);
					bfs(cnt+1);
					check[i]=false;
					sb.setLength(sb.length()-1);
				}
			}
		}
		
	}
	
		
}
