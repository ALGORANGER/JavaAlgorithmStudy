import java.util.*;
import java.io.*;

public class _BOJ_DP_G3_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(re.readLine());
        for(int t = 1; t <= testCase; t++){
            int n = Integer.parseInt(re.readLine());
            int[] inputData = new int[n];
            StringTokenizer token = new StringTokenizer(re.readLine());
            for(int i = 0; i < n; i++){
                inputData[i] = Integer.parseInt(token.nextToken());
            }
            
            int[] dp = new int[n];
            dp[1] = inputData[0] + inputData[1];
            dp[2] = Integer.min(inputData[0] + 2*(inputData[1] + inputData[2]), 2* dp[1] + inputData[2]);
            for(int i = 3; i < n; i++){
                dp[i] = Integer.min(2*dp[i-1]+inputData[i], 2 * dp[i-2] + 2 * (inputData[i-1]+inputData[i]));
            }
            System.out.println(1);
        }
        re.close();
    }
}
