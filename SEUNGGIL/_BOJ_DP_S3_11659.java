import java.util.*;
import java.io.*;

public class _BOJ_DP_S3_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token = new StringTokenizer(re.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[] dp = new int[n+1];

        token = new StringTokenizer(re.readLine());
        for(int i = 1; i < n+1; i++){
            dp[i] = dp[i-1] + Integer.parseInt(token.nextToken());
        }

        StringBuilder ans = new StringBuilder();
        for(int j = 0; j < k; j++){
            token = new StringTokenizer(re.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            ans.append(dp[to]-dp[from-1]).append('\n');
        }
        System.out.print(ans);

        re.close();
    }
}
