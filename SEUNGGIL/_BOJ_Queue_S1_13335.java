import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class Truck{
    public int endTime;
    public int weight;

    public Truck(int endTime, int weight) {
        this.endTime = endTime;
        this.weight = weight;
    }
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){

            String[] inputData = reader.readLine().split(" ");
			int truckCount = Integer.parseInt(inputData[0]);
            int bridgeLength = Integer.parseInt(inputData[1]);
			int maxWeight = Integer.parseInt(inputData[2]);

            ArrayList<Integer> line = new ArrayList<>(truckCount);
            for(String s : reader.readLine().split(" ")){
                line.add(Integer.parseInt(s));
            }

            int ans = 1;
            int index = 0;
            int weight = 0;
            Queue<Truck> queue = new LinkedList<>();
            

            while(index < truckCount){
                if(!queue.isEmpty()){
                    if(queue.peek().endTime == ans){
                        Truck finished =queue.poll();
                        weight -= finished.weight;
                    }
                }
                if(line.get(index) + weight <= maxWeight){
                    queue.offer(new Truck(ans+bridgeLength, line.get(index)));
                    weight += line.get(index);
                    ans++;
                    index++;
                }else{
                    ans = queue.peek().endTime;
                }
            }
            while(!queue.isEmpty()){
                ans = queue.poll().endTime;
            }
            writer.write(Integer.toString(ans));
		}catch(Exception e){

		}
    }
}