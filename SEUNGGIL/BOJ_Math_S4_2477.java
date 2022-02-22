import java.util.*;
import java.io.*;

public class BOJ_Math_S4_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int dense = Integer.parseInt(re.readLine());

        List<int[]> cal = new ArrayList<>();

        int x = 0, y = 0;
        int minx = 0, miny = 0;
        int maxX = 0, maxY = 0;
        for (int i = 0; i < 6; i++) {
            token = new StringTokenizer(re.readLine());
            int dir = Integer.parseInt(token.nextToken());
            int length = Integer.parseInt(token.nextToken());
            
            switch(dir){
                case 1:
                    y += length;
                    break;
                case 2:
                    y -= length;
                    break;
                case 3:
                    x += length;
                    break;
                case 4:
                    x -= length;
                    break;
            }
            cal.add(new int[]{x,y});
            minx = Integer.min(x, minx);
            miny = Integer.min(y, miny);

            maxX = Integer.max(maxX, x);
            maxY = Integer.max(maxY, y);
        }

        maxX -= minx;
        maxY -= miny;
        for (int i = 0; i < 6; i++) {
            cal.get(i)[0] -= minx;
            cal.get(i)[1] -= miny;
        }
        
        int [] notExist;
        int [] center = {0,0};

        for (int i = 0; i < 6; i++) {
            if(cal.get(i)[0] > 0 && cal.get(i)[0] < maxX && cal.get(i)[1] > 0 && cal.get(i)[1] < maxY)
                center = new int[]{cal.get(i)[0], cal.get(i)[1]};
        }

        int[] test = new int[4];
        for (int i = 0; i < 6; i++) {
            if(cal.get(i)[0] == 0 && cal.get(i)[1] == maxY){
                test[0] = 1;
            }else if(cal.get(i)[0] == maxX && cal.get(i)[1] == 0){
                test[1] = 1;
            }else if(cal.get(i)[0] == maxX && cal.get(i)[1] == maxY){
                test[2] = 1;
            }else if(cal.get(i)[0] == 0 && cal.get(i)[1] == 0){
                test[3] = 1;
            }
        }
        
        if(test[0] == 0){
            notExist = new int[]{0,maxY};
        }else if(test[1] == 0){
            notExist = new int[]{maxX,0};
        }else if(test[2] == 0){
            notExist = new int[]{maxX,maxY};
        }else{
            notExist = new int[]{0,0};
        }
        int ans = Math.abs(notExist[0] - center[0]) * Math.abs(notExist[1] - center[1]);
        System.out.println((maxX * maxY - ans) * dense);

        re.close();
    }
}
