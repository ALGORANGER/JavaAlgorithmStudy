package com.ssafy.algo.day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _BOJ_Sort_S1_1946 {
	
	private static int T, N;
	private static int member; // 선발된 신입사원 수
	private static int curD; // 가장 최근 합격한 신입사원의 서류 점수
	private static int [][] rank; // 지원자들의 서류 성적 순위, 면접 성적 순위
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); 
			rank = new int[N][2];
			
			// 입력받을 때 바로 정렬해버리기~
			for(int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int doc = Integer.parseInt(st.nextToken());
				int itv = Integer.parseInt(st.nextToken());
				rank[itv-1][0] = doc;
				rank[itv-1][1] = itv;
			}
			
			/*
			for(int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				rank[n][0] = Integer.parseInt(st.nextToken());
				rank[n][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(rank, (o1, o2) -> { 
				if(o1[1] == o2[1]) { 
					return Integer.compare(o1[0],o2[0]);
				} else { 
					return Integer.compare(o1[1],o2[1]); 
				} 
			});
			*/
			
			member = 1; 
			curD = rank[0][0];
			
			for(int n = 1; n < N; n++) {
				if(curD == 1) {
					break;
				}
				
				if(curD > rank[n][0]) {
					curD = rank[n][0];
					member++;
				}
			}
			
			System.out.println(member);
			
		}
		
		br.close();
		
	}

}
