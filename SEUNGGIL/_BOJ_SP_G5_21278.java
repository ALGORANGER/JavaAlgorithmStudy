import java.util.*;
import java.io.*;

public class _BOJ_SP_G5_21278 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        final int INF = 100000;
        StringTokenizer token = new StringTokenizer(re.readLine());

        int node = Integer.parseInt(token.nextToken());
        int edge = Integer.parseInt(token.nextToken());

        int[][] dp = new int[node+1][node+1];
        for(int i = 1; i < node+1; i++)
            Arrays.fill(dp[i], INF);
        for(int i = 1; i < node+1; i++)
            dp[i][i] = 0;
        for(int i = 0; i < edge; i++){
            token = new StringTokenizer(re.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            dp[a][b] = 1;
            dp[b][a] = 1;
        }
        

        for(int i = 1; i < node+1; i++){
            for(int j = 1; j < node+1; j++){
                for(int k = 1; k < node+1; k++){
                    dp[j][k] = Integer.min(dp[j][k], dp[j][i]+dp[i][k]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for(int i = 1; i < node+1; i++){
            for(int j = i+1; j < node+1; j++){
                int totalDistance = 0;

                for(int k = 1; k < node+1; k++){
                    totalDistance += Integer.min(dp[k][i], dp[k][j]);
                }
                
                if(ans > totalDistance){
                    ans = totalDistance;
                    a = i;
                    b = j;
                }
            }
        }
        
        System.out.print(""+ a +' ' + b +' '+ ans * 2);
        re.close();
    }
}
