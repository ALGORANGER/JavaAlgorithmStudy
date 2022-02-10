import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class _BOJ_Map_S1_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String,Integer> inputData = new TreeMap<>();
        String s;
        int total = 0;
        while((s=re.readLine()) != null){
            int value = inputData.getOrDefault(s, 0);
            inputData.put(s, value+1);
            total++;
        }

        double sum = total;
        for (Entry<String, Integer> t : inputData.entrySet()) {
            wr.write(String.format("%s %.4f\n", t.getKey(), t.getValue()*100/sum));
        }

        wr.close();
        re.close();
    }
}
