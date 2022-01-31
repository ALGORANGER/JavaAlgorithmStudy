import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			int n = Integer.parseInt(reader.readLine());
			int me = Integer.parseInt(reader.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for (int i = 0; i < n-1; i++)
				pq.add(Integer.parseInt(reader.readLine()));
			
			int ans = 0;
			
			while(!pq.isEmpty() && me <= pq.peek()) {
				pq.add((pq.poll()-1));
				me++;
				ans++;
			}
			System.out.print(ans);
			
		}catch(Exception e) {
			
		}
		
	}

}
