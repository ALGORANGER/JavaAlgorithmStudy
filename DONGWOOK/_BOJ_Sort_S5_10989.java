package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _BOJ_Sort_S5_10989 {
	static int[] arr = new int[10000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
//		arr = new int[N];
		
		for (int n = 0; n < N; n++) {
			arr[Integer.parseInt(br.readLine())]++; 
		}
		
		for(int i = 1;i<10000000; i++) {
			while(arr[i]!=0) {
				bw.write(i+"\n");
				arr[i]--;
			}
		}
		
//		Arrays.sort(arr);
		
//		for(int n : arr) {
//			bw.write(n+"\n");
//		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}