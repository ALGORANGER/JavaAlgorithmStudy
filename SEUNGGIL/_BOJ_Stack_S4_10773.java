import java.io.*;
import java.util.*;

public class _BOJ_Stack_S4_10773 {

	public static void main(String[] args) {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
			int k = Integer.parseInt(reader.readLine());
			Stack<Integer> inputData = new Stack<Integer>();
			for (int i = 0; i < k; i++) {
				int n = Integer.parseInt(reader.readLine());
				if(n != 0)
					inputData.push(n);
				else
					inputData.pop();
			}
			
			int ans = 0;
			for (Integer i : inputData) {
				ans += i;
			}
			System.out.print(ans);
			
		}catch (Exception e){
			
		}
		
	}

}
