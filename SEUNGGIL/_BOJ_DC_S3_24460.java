import java.util.*;
import java.io.*;

public class _BOJ_DC_S3_24460 {
    static int divide(int[][] map, int x, int y, int size){
        if(size == 1)
            return map[x][y];
        else{
            int a = divide(map, x, y, size/2);
            int b = divide(map, x+size/2, y, size/2);
            int c = divide(map, x, y+size/2, size/2);
            int d = divide(map, x+size/2, y+size/2, size/2);

            if(a > b){
                int temp = b;
                b = a;
                a = temp;
            }

            if(c > d){
                int temp = c;
                c = d;
                d = temp;
            }

            a = Math.max(a,c);
            b = Math.min(b,d);
            
            return Math.min(a,b);

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(re.readLine());

        int[][] map = new int[n][n];


        for(int i = 0; i < n; i++){
            StringTokenizer token = new StringTokenizer(re.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        System.out.print(divide(map, 0, 0, n));

        re.close();        
    }

}
