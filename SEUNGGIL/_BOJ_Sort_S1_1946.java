import java.io.*;
import java.util.*;

public class _BOJ_Sort_S1_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(re.readLine());

        for(int t = 0; t < testCase; t++){
        
            int n = Integer.parseInt(re.readLine());
            List<People> inputData = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringTokenizer token = new StringTokenizer(re.readLine());
                inputData.add(new People(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken())));
            }
            inputData.sort(null);
            int rank = inputData.get(0).talk;
            int ans = 1;
            for(int i = 1; i < n; i++){
                if(inputData.get(i).talk <= rank){
                    ans++;
                    rank = inputData.get(i).talk;
                }
            }
            wr.write(Integer.toString(ans));
            wr.newLine();
        }

        wr.close();
        re.close();        
    }
}

class People implements Comparable<People>{
    int paper;
    int talk;

    public People(int paper, int talk) {
        this.paper = paper;
        this.talk = talk;
    }


    @Override
    public int compareTo(People o) {
        if(paper < o.paper)
            return -1;
        else if(paper == o.paper)
            return 0;
        else
            return 1;
    }
    
}