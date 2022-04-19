import java.util.*;
import java.io.*;

public class _BOJ_DP_S1_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token = new StringTokenizer(re.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[][] dp = new int[n+1][n+1];


        for(int i = 1; i < n+1; i++){
            token = new StringTokenizer(re.readLine());
            for(int j = 1; j < n+1; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + Integer.parseInt(token.nextToken());
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < k; i++){
            token = new StringTokenizer(re.readLine());
            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());

            ans.append(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]).append('\n');
        }
        System.out.print(ans);

        re.close();
    }
}
