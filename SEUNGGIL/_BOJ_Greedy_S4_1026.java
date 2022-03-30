import java.util.*;
import java.io.*;

public class _BOJ_Greedy_S4_1026{
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(re.readLine());
        StringTokenizer token = new StringTokenizer(re.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(re.readLine());
        for(int i = 0; i < n; i++){
            b[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);
        
        int ans = 0;

        for(int i = 0; i < n; i++){
            ans += a[i] * b[n-i-1];
        }
        System.out.print(ans);
        re.close();
    }
}