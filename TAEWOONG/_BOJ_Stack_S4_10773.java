import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _BOJ_Stack_S4_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		
		int K =0;int sum=0;
		K= Integer.parseInt(sc.readLine());
		
		
		int[] s = new int[K];
		
		for(int i=0;i<K;i++) {
			int N = Integer.parseInt(sc.readLine());
			if(N!=0) {
				stack.push(N);
			}else {
				stack.pop();
			}
			
		}
		
		for(int i:stack) {
			sum +=i;
		}
		
		System.out.println(sum);

	}
	
	

}