import java.util.*;
import java.io.*;
public class _BOJ_PQ_G5_7662 {

	public static void main(String[] args) {
		TreeMap<Integer, Integer> pqMap = new TreeMap<>();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){

			int testCase = Integer.parseInt(reader.readLine());
			for(int i = 0; i < testCase; i++){
				pqMap.clear();
				int orderCount = Integer.parseInt(reader.readLine());
				
				for(int o = 0; o < orderCount; o++){
					String[] order = reader.readLine().split(" ");

					if(order[0].charAt(0) == 'I'){
						int n = Integer.parseInt(order[1]);
						if(pqMap.containsKey(n)){
							pqMap.replace(n,pqMap.get(n)+1);
						}else{
							pqMap.put(n, 1);
						}
					}else{
						if(pqMap.isEmpty())
							continue;
						if(order[1].charAt(0) == '-'){
							int key = pqMap.firstKey();
							int value = pqMap.firstEntry().getValue();
							if(value == 1)
								pqMap.remove(key);
							else
								pqMap.replace(key, value - 1);
						}else{
							int key = pqMap.lastKey();
							int value = pqMap.lastEntry().getValue();
							if(value == 1)
								pqMap.remove(key);
							else
								pqMap.replace(key, value - 1);
						}
					}
				}
				if(pqMap.isEmpty()){
					writer.write("EMPTY\n");
				}else{
					writer.write(pqMap.lastKey().toString());
					writer.append(' ');
					writer.write(pqMap.firstKey().toString());
					writer.newLine();
				}
			}
			
		}catch(Exception e){

		}
	}

}
