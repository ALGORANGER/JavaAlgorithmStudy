import java.util.*;
import java.io.*;

public class _BOJ_Greedy_S2_15729 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(re.readLine());
        
        boolean[] inputData = new boolean[n];
        StringTokenizer token = new StringTokenizer(re.readLine());

        for(int i = 0; i < n; i++){
            inputData[i] =  token.nextToken().charAt(0) == '1' ? true : false;    
        }
        boolean[] result = new boolean[n];
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(result[i] != inputData[i]){
                answer++;
                result[i] = !result[i];
                for(int j = i+1; j < Integer.min(i+3, n); j++){
                    result[j] = !result[j];
                }
            }
        }
        System.out.print(answer);
        re.close();
    }
}
