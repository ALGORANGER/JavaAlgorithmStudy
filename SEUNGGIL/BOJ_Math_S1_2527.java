import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Math_S1_2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            StringTokenizer token = new StringTokenizer(re.readLine());

            int x1 = Integer.parseInt(token.nextToken()), y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken()), y2 = Integer.parseInt(token.nextToken());
            int x3 = Integer.parseInt(token.nextToken()), y3 = Integer.parseInt(token.nextToken());
            int x4 = Integer.parseInt(token.nextToken()), y4 = Integer.parseInt(token.nextToken());

            int minX = Integer.max(x1, x3);
            int maxX = Integer.min(x2, x4);

            int minY = Integer.max(y1, y3);
            int maxY = Integer.min(y2, y4);

            int xResult = maxX - minX;
            int yResult = maxY - minY;

            if(xResult < 0 || yResult < 0){
                ans.append('d');
            }else if(xResult == 0 && yResult == 0){
                ans.append('c');
            }else if(xResult > 0 && yResult > 0){
                ans.append('a');
            }else{
                ans.append('b');
            }
            ans.append('\n');
        }
        System.out.print(ans);
        re.close();
    }
}
