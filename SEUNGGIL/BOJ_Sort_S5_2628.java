import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class BOJ_Sort_S5_2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(re.readLine());
        int n = Integer.parseInt(token.nextToken()), m = Integer.parseInt(token.nextToken());
        
        boolean[][] inputData = new boolean[m][n];
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        int cutCnt = Integer.parseInt(re.readLine());
        for (int i = 0; i < cutCnt; i++) {
            token = new StringTokenizer(re.readLine());
            if(token.nextToken().charAt(0) == '0')
                row.add(Integer.parseInt(token.nextToken()));
            else
                column.add(Integer.parseInt(token.nextToken()));
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(inputData[i][j])
                    continue;

                int cand = 0;
                for (int j2 = i; j2 < m && ((j2 == i) || !row.contains(j2)) ; j2++) {
                    for (int k = j; k < n && ((k == j) || !column.contains(k)); k++) {
                        if(inputData[j2][k]){
                            throw new IOException();
                        }
                        inputData[j2][k] = true;
                        cand++;
                    }
                }
                ans = Integer.max(ans, cand);
            }
        }
        System.out.println(ans);
        re.close();
    }
}
