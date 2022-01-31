import java.io.*;
import java.util.*;

public class _BOJ_Queue_S4_10845 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
			int n = Integer.parseInt(reader.readLine());
			
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				String[] s = reader.readLine().split(" ");
				if(s[0].equals("push")) {
					queue.offer(Integer.parseInt(s[1]));
				}else {
					switch(s[0]) {
					case "front":
						if(queue.isEmpty())
							writer.write("-1");
						else
							writer.write(Integer.toString(queue.peek()));
						break;
					case "back":
						if(queue.isEmpty())
							writer.write("-1");
						else {
							Integer[] a = queue.toArray(new Integer[0]);
							writer.write(Integer.toString(a[a.length-1]));
						}
						break;
					case "size":
						writer.write(Integer.toString(queue.size()));
						break;
					case "empty":
						writer.write(Integer.toString(queue.isEmpty() ? 1 : 0));
						break;
					case "pop":
						if(queue.isEmpty())
							writer.write("-1");
						else
							writer.write(Integer.toString(queue.poll()));
						break;
					}
					writer.newLine();
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
