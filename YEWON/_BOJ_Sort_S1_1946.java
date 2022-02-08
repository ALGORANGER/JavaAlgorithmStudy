package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _BOGJ_Sort_S1_1946 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder answer = new StringBuilder();
	
	private static int T;
	private static int N;
	private static int[][] members;
	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			members= new int[N][2];
			
			for(int j = 0; j<N; j++) { // 신입사원 정보 입력받기
				st = new StringTokenizer(br.readLine());
				members[j][0] = Integer.parseInt(st.nextToken()); // 서류 성적
				members[j][1] = Integer.parseInt(st.nextToken()); // 면접 성적
			} // 입력 끝
			
			Arrays.sort(members, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {   // 서류 성적 등수를 기준으로
					return (o1[0] - o2[0]);             // 오름차순 정렬
				}
				
			});
			
			int score = members[0][1]; // 상위 합격자의 면접 성적 최소값을 담아 둘 변수 ( 처음은 1등 면접 성적으로 초기화)
			cnt = 1;
			
			for(int j = 1; j<N; j++) { // 서류 2등~N등 면접 성적 비교 (서류 1등은 무조건 합격)
				if(members[j][1] < score) { // 서류 등수가 자신보다 상위인 사람 보다 면접 성적이 높아야 함
					score = members[j][1];  // 상위 합격자의 면접 등수를 기준으로 바꿈
					cnt++;
				}
			}
			answer.append(cnt+"\n");
			
		} // T.C 끝
		System.out.println(answer);
	}

}
