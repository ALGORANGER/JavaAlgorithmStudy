import java.io.*;
import java.util.*;
public class _BOJ_Queue_S5_1158 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
                String[] s = reader.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            Queue<Integer> queue = new LinkedList<>();
            
            // 1부터 n까지 사람 넣기
            for(int i = 1; i <= n; i++){
                queue.offer(i);
            }

            int count = 0;
            List<Integer> answer = new ArrayList<>();
            while(queue.size() > 0){
                count++;
                count %= k;

                if(count == 0){
                    answer.add(queue.poll());
                }else{
                    queue.offer(queue.poll());
                }
            }

            writer.write('<');
            for(int i = 0 ; i < answer.size() -1; i++){
                writer.write(Integer.toString(answer.get(i)));
                writer.write(", ");
            }
            writer.write(Integer.toString(answer.get(answer.size()-1)));
            writer.write('>');
            

        } catch (Exception e) {
        }
    }
}
