package _03_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_DC_S4_11582 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int K = Integer.parseInt(br.readLine());
		int t = N;
		int cnt = 0;
		
		while(t != K) {
			t/=2;
			cnt++;
		}
		
		int e = (int)Math.pow(2, cnt);
		
		for(int i=0; i<N; i+=e) {
			Arrays.sort(arr, i, i+e);
		}
		
		for(int n : arr) {
			sb.append(n+" ");
		}
		sb.setLength(sb.length()-1);
		
		System.out.println(sb.toString());
	}

}
