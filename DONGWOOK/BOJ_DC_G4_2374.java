package _03_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BOJ_DC_G4_2374 {
	static int N;
	static long answer;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 입력 받을 배열 선언
		arr = new int[N];
		arr[0] = Integer.parseInt(br.readLine());
		int cnt = 1;
		
		//같은 수가 연속해서 들어오면 한 개만 입력 받도록 한다.
		for (int i = 1; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (arr[cnt - 1] != num) {
				arr[cnt++] = num;
			}
		}
		
		//가장 큰 수를 찾고 인덱스 저장
		int index = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<cnt; i++) {
			if(arr[i]>max) {
				max = arr[i];
				index = i;
			}
		}
		
		/*
		 * answer += max - (max 기준 왼쪽에서의 가장 큰값)
		 * answer += max - (max 기준 오른쪽에서의 가장 큰값)		
		*/
		
		divide(0, index, max);		//max 값 기준 왼쪽 탐색
		divide(index, cnt, max);	//max 값 기준 오른쪽 탐색
		
		System.out.println(answer);
	}
	static void divide(int start, int end, int preMax) {
		if(start>=end) {
			return;
		}
		
		int index = 0;
		int max = Integer.MIN_VALUE;
		for(int i = start; i<end; i++) {
			if(arr[i]>max) {
				max = arr[i];
				index = i;
			}
		}
		
		answer += preMax - max;
		divide(start, index, max);
		divide(index+1, end, max);
	}
}
