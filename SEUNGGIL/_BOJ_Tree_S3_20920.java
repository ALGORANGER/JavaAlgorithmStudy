import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class Word implements Comparable<Word>{
    int cnt;
    String word;
    public Word(int cnt, String word) {
        this.cnt = cnt;
        this.word = word;
    }

    @Override
    public int compareTo(Word o) {
        if(cnt != o.cnt)
            return Integer.compare(o.cnt, cnt);
        else if(word.length() != o.word.length())
            return Integer.compare(o.word.length(), word.length());
        else
            return word.compareTo(o.word);
    }

}
public class _BOJ_Tree_S3_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter rw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(re.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        Map<String,Integer> inputData = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String key = re.readLine();
            int value = inputData.getOrDefault(key, 0);
            inputData.put(key, value+1);
            //inputData.merge(re.readLine(), 1, Integer::sum);
        }
        
        Set<Word> ans = new TreeSet<>();
        for(Entry<String, Integer> entry : inputData.entrySet()){
            if(entry.getKey().length() >= m){
                ans.add(new Word(entry.getValue(), entry.getKey()));
            }
        }

        for (Word word : ans) {
            rw.write(word.word);
            rw.newLine();
        }

        re.close();
        rw.close();
    }
}
