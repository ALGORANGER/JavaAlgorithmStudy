import java.io.*;

public class _BOJ_Sort_S5_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(re.readLine());
        int[] inputData = new int[10010];
        
        for(int i = 0; i < n; i++){
            inputData[Integer.parseInt(re.readLine())]++;
        }
        
        for(int i = 1; i <= 10000; i++){
            for(int j = 0; j < inputData[i]; j++){
                wr.write(Integer.toString(i));
                wr.newLine();
            }
        }
        wr.close();
        re.close();
    }
}
