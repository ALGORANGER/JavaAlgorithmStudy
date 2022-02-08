package day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_Stack_G5_2493 {
	
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Stack<int []> tower = new Stack<>();
		int[] result = new int[N];
		
		String[] str = br.readLine().split(" ");
		for(int n = 0; n < N; n++) {
			int cur = Integer.parseInt(str[n]);
			
			while(!tower.isEmpty()) {
				if(tower.peek()[1] > cur) { // 스택 최상위(가장높은타워)가 현재보다 높다면
					System.out.print(tower.peek()[0] + " "); // 가장 높은 타워 출력
					break;
				}
				tower.pop(); // 현재 들어온 타워보다 낮은 타워는 모두 빼 버리기
			}
			
			if(tower.isEmpty()) { // 현재 들어온 타워가 가장 높아서 스택이 비었다면 0 출력
				System.out.print("0 ");
			}
			tower.push(new int[] {n+1, cur});
		}
		
		br.close();

	}

}
