import java.util.*;
import java.io.*;

public class _BOJ_SP_G4_11657{
    public static void main(String[] args) throws IOException {
        final int INF = 50_000_000;
        
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(re.readLine());

        int node = Integer.parseInt(token.nextToken());
        int edge = Integer.parseInt(token.nextToken());

        int[][] dp = new int[node+1][node+1];

        for(int i = 0; i < node+1; i++){
            Arrays.fill(dp[i], INF);
        }
        
        for(int i = 0; i < edge; i++){
            token = new StringTokenizer(re.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int length = Integer.parseInt(token.nextToken());
            dp[start][end] = Integer.min(dp[start][end], length);
        }

        for(int i = 1; i < node+1; i++){
            for(int j = 1; j < node+1; j++){
                for(int k = 1; k < node+1; k++){
                    if(dp[j][i] == INF || dp[i][k] == INF)
                        continue;
                    dp[j][k] = Integer.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }
        for(int i = 1; i < node+1; i++){
            if(dp[i][i] < 0 && dp[1][i] != INF){
                System.out.println(-1);
                re.close();
                return;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int k = 2; k < node+1; k++){
            if(dp[1][k] == INF)
                ans.append(-1).append('\n');
            else
                ans.append(dp[1][k]).append('\n');
        }
        System.out.print(ans);
        
        re.close();
    }
}