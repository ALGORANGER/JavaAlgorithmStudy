import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class _BOJ_DC_G5_3020{
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(re.readLine());
        int width = Integer.parseInt(token.nextToken());
        int height = Integer.parseInt(token.nextToken());

        int[] inputData = new int[height];

        for(int i = 0; i < width; i++){
            int n = Integer.parseInt(re.readLine());

            if(i % 2 == 0){
                inputData[0] += 1;
                inputData[n] -= 1;
            }else{
                inputData[height-n] += 1;
            }
        }

        TreeMap<Integer,Integer> cumul = new TreeMap<>();
        int status = 0;
        
        for (int i : inputData) {
            status += i;
            cumul.put(status, cumul.getOrDefault(status, 0) + 1);
        }
        Entry<Integer,Integer> result = cumul.firstEntry();
        System.out.print(result.getKey() + " " + result.getValue());
        re.close();
    }
}