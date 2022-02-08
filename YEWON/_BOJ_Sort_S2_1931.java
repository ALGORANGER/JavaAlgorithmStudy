package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _BOJ_Sort_S2_1931 {
	private static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int T;
	private static int [][] timeTable;
	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		timeTable = new int[T][2];
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			timeTable[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			timeTable[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}	
			
		Arrays.sort(timeTable, new Comparator<int[]>() { // 끝나는 시간 정렬

			@Override
			public int compare(int[] o1, int[] o2) { // 양수 : 바꿈(오름차순)

				if(o1[1] == o2[1]) { // 종료시간이 같은 경우
					return o1[0] - o2[0]; // 시작시간을 비교하여 시작 시간이 빠른 순으로 정렬.
				}
				
				return o1[1] - o2[1]; // 종료시간 오름차순 정렬.
			}
			
		});
		
		cnt = 0;
		int endTime = 0;
		
		for(int i = 0; i<T; i++) {
			if(endTime <= timeTable[i][0]) {
				endTime = timeTable[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
