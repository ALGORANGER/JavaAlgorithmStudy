import java.util.*;
import java.io.*;

class Conference implements Comparable<Conference>{
    
    int start;
    int end;

    public Conference(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Conference o) {
        if(end != o.end){
            return Integer.compare(end, o.end);
        }else{
            return Integer.compare(start, o.start);   
        }
    }

    
}

public class _BOJ_Sort_S2_1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Conference> inputData = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");

            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);

            inputData.add(new Conference(from, to));
        }

        Collections.sort(inputData);

        int ans = 0;
        int time = 0;

        for (int i = 0; i < inputData.size(); i++) {
            Conference c = inputData.get(i);
            if(time <= c.start){
                time = c.end;
                ans++;
            }
        }
        System.out.print(ans);    
        reader.close();
    }
}
