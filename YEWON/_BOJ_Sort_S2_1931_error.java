package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _BOJ_Sort_S2_1931_error { // 테스트 케이스 예시만 맞음. 오류 : ArrayIndexOutOfBounds
	private static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static int T;
	private static int ST, FT;
	private static int cnt;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(_BOJ_Sort_S2_1931_error.class.getResourceAsStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		int[] timeTable = new int[25];                
		boolean isMeet = true;
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			ST = Integer.parseInt(st.nextToken());
			FT = Integer.parseInt(st.nextToken());
			
			for(int j = ST; j <= FT; j++) {
				if(timeTable[j]==1) {
					isMeet = false;
					break;
				}else {
					timeTable[j] = 1;
					isMeet = true;
				}
			}
			
			if(isMeet) {
				timeTable[ST] = 0;
				timeTable[FT] = 0;
				cnt++;
			}
		}
		
		System.out.print(cnt);
		
		

	}

}
