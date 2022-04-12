import java.util.*;
import java.io.*;

public class _BOJ_SP_G3_1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(re.readLine());
        int node = Integer.parseInt(token.nextToken());
        int edge = Integer.parseInt(token.nextToken());

        int[][] dp = new int[node+1][node+1];

        final int INF = 300000;
        for(int i = 1; i < node+1; i++){
            Arrays.fill(dp[i], INF);
        }

        for(int i = 0; i < edge; i++){
            token = new StringTokenizer(re.readLine());
            dp[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())] = 1;
        }

        for(int i = 1; i < node+1; i++){
            for(int j = 0; j < node+1; j++){
                for(int k = 0; k < node+1; k++){
                    if(j == k)
                        continue;
                    dp[j][k] = Integer.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int query = Integer.parseInt(re.readLine());
        for(int i = 0; i < query; i++){
            token = new StringTokenizer(re.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            if(dp[a][b] != INF){
                ans.append(-1).append('\n');
            }else if(dp[b][a] != INF){
                ans.append(1).append('\n');
            }else{
                ans.append(0).append('\n');
            }
        }

        System.out.println(ans);
        re.close();
    }
}
