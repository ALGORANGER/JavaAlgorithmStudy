import java.util.*;
import java.io.*;

public class _BOJ_DP_S1_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(re.readLine());

        int[][] dp = new int[n][10];
        dp[0] = new int[]{0,1,1,1,1,1,1,1,1,1};
        for(int i = 1; i < n; i++){
            dp[i][0] =  dp[i - 1][1] % 1000000000;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 1000000000;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % 1000000000;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][4]) % 1000000000;
            dp[i][4] = (dp[i - 1][3] + dp[i - 1][5]) % 1000000000;
            dp[i][5] = (dp[i - 1][4] + dp[i - 1][6]) % 1000000000;
            dp[i][6] = (dp[i - 1][5] + dp[i - 1][7]) % 1000000000;
            dp[i][7] = (dp[i - 1][6] + dp[i - 1][8]) % 1000000000;
            dp[i][8] = (dp[i - 1][7] + dp[i - 1][9]) % 1000000000;
            dp[i][9] =  dp[i - 1][8] % 1000000000;
        }
        int ans = 0;
        for(int iter : dp[n-1]){
            ans = (ans + iter) % 1000000000;
        }
        System.out.print(ans);
        
        re.close();
    }
}
