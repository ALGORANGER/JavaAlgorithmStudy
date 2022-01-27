import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _BOJ_Queue_S4_10845 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		N=Integer.parseInt(sc.readLine());
		int A=0;
		
		Queue<Integer> q = new LinkedList<>();
		String[] str = {};
		
		for(int i=0;i<N;i++) {
			
			String K = sc.readLine();
			
			if(K.contains("push")) {
				str= K.split(" ");
				A=Integer.parseInt(str[1]);
				q.offer(A);
			}
			else if(K.equals("pop")){			
				if(q.peek()!=null)
				System.out.println(q.poll());
				else System.out.println("-1");
			}
			else if(K.equals("size")) {
				System.out.println(q.size());
			}
			else if(K.equals("empty")) {
				if(q.isEmpty()) {
					System.out.println("1");
				}else System.out.println("0");
			}
			else if(K.equals("front")) {
				if(q.peek()!=null)
				System.out.println(q.peek());
				else System.out.println("-1");
			}
			else if(K.equals("back")) {
				if(q.peek()!=null)
					System.out.println(A);
				else System.out.println("-1");
				
			}
		}

	}

}
