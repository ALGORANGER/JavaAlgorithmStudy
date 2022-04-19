import java.util.*;
import java.io.*;

public class _BOJ_DP_S3_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(re.readLine());
        int[] time = new int[n];
        int[] money = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer token = new StringTokenizer(re.readLine());
            time[i] = Integer.parseInt(token.nextToken());
            money[i] = Integer.parseInt(token.nextToken());
        }

        int[] dp = new int[n];
        if(time[n-1] == 1)
            dp[n-1] = money[n-1];


        int ans = dp[n-1];
        for(int i = n-2; i >= 0; i--){
            int value = 0;

            if(i+time[i] < n){
                value = Integer.max(value, money[i] + dp[i+time[i]]);
            }else if(i+time[i] == n){
                value = Integer.max(value, money[i]);
            }

            dp[i] = Integer.max(value, dp[i+1]);

            if(ans < dp[i])
                ans = dp[i];
        }
        System.out.println(ans);
        re.close();
    }
}
