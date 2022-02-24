import java.util.*;
import java.io.*;

public class BOJ_Math_S4_10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token = new StringTokenizer(re.readLine());
        
        int X = Integer.parseInt(token.nextToken());
        int Y = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(re.readLine());
        int x = Integer.parseInt(token.nextToken());
        int y = Integer.parseInt(token.nextToken());

        int t = Integer.parseInt(re.readLine());
        re.close();
        int now = 0;
        int[] dir = {1,1};

        int length = Integer.min(X-x, Y-y);
            
        x += dir[0] * length;
        y += dir[1] * length;
        now += length;
        
        if((x == X || x == 0) && (y == Y || y == 0)){
            dir[0] *= -1;
            dir[1] *= -1;
        }
        else if(x == X || x == 0){
            dir[0] *= -1;
        }else if(y == Y || y == 0){
            dir[1] *= -1;
        }
        int [] startdir = new int[]{dir[0],dir[1]};
        int [] startLoc = new int[]{x,y};
        int startNow = now;
        
        while(now < t){
            //System.out.println(y + " " + x);
            length = Integer.min((dir[0] == 1 ? X-x : x), (dir[1]==1 ? Y-y : y));
            
            x += dir[0] * length;
            y += dir[1] * length;
            now += length;

            if((x == X || x == 0) && (y == Y || y == 0)){
                dir[0] *= -1;
                dir[1] *= -1;
            }
            else if(x == X || x == 0){
                dir[0] *= -1;
            }else if(y == Y || y == 0){
                dir[1] *= -1;
            }

            if(now != startNow && startLoc[0] == x && startLoc[1] == y && (dir[0] == startdir[0]) && (dir[1] == startdir[1])){
                now += ((t-now)/(now-startNow))*(now-startNow);
            }
        }

        if((x == X || x == 0) && (y == Y || y == 0)){
            dir[0] *= -1;
            dir[1] *= -1;
        }
        else if(x == X || x == 0){
            dir[0] *= -1;
        }else if(y == Y || y == 0){
            dir[1] *= -1;
        }

        x -= dir[0] * (now - t);
        y -= dir[1] * (now - t);

        System.out.print(x + " " + y);
        
    }
}
