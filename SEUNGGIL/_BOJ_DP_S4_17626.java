import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _BOJ_DP_S4_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(re.readLine());

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++)
            dp[i] = Integer.MAX_VALUE;

        for(int i = 2; i < n+1; i++){
            if(Math.sqrt(i) == i){
                dp[i] = 1;
            }else{
                for(int j = 1, length = (int)Math.sqrt(i); j <= length; j++){
                    dp[i] = Integer.min(dp[i], dp[i-j*j]+1);
                }
            }
        }

        System.out.print(dp[n]);
        re.close();
    }
    
    
}
