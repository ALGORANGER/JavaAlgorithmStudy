import java.util.*;
import java.io.*;

public class _BOJ_DP_S3_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 11; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        int testCase = Integer.parseInt(re.readLine());

        StringBuilder ans = new StringBuilder();
        for(int t = 0; t < testCase; t++){
            int n = Integer.parseInt(re.readLine());
            
            ans.append(dp[n]).append('\n');
        }
        
        System.out.print(ans);
        re.close();
    }
}
