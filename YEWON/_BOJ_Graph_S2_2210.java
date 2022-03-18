package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_S2_2210_숫자판점프 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;
	
	private static char[][] numbers = new char [5][5];
	private static HashSet<String> number;
	private static String s;
	
	private static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		// delete
		br = new BufferedReader(new StringReader(src));
		// delete
		
		for(int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 5; c++) {
				numbers[r][c] = st.nextToken().charAt(0);
			}
		}
		
		// 입력완료
		
		s = new String();
		number = new HashSet<String>();
		
		for(int r = 0; r <5; r++) {
			for(int c = 0; c < 5; c++) {
				dfs(r, c, 0, s);
			}
		}
		
		System.out.println(number.size());

	}
	
	private static void dfs(int r, int c, int depth, String s) {
		// base part
		if(depth == 6) {
			number.add(s);
			return;
		}
		
		// inductive part
		for(int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc)) {
				dfs(nr, nc, depth+1, s+numbers[r][c]);
			}
		}
	}
	
	private static boolean isIn(int nr, int nc) {
		if(nr < 5 && nc < 5 && nr >= 0 && nc >= 0) {
			return true;
		}else {
			return false;
		}
	}
	
	private static String src = "1 1 1 1 1\r\n" + 
			"1 1 1 1 1\r\n" + 
			"1 1 1 1 1\r\n" + 
			"1 1 1 2 1\r\n" + 
			"1 1 1 1 1";

}
