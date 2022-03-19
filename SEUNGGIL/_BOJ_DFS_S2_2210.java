import java.util.*;
import java.io.*;

public class _BOJ_DFS_S2_2210 {
    static final int[][] delta = {{0,1}, {1,0}, {-1,0},{0,-1}};
    static Set<Integer> answer = new HashSet<>();
    static int[][] map = new int[5][5];

    static void dfs(int loc, int nowValue, int count){
        if(count == 6){
            answer.add(nowValue);
            return;
        }
        int x = loc / 5;
        int y = loc % 5;
        for(int i = 0; i < 4; i++){
            int nextX = x + delta[i][0];
            int nextY = y + delta[i][1];

            if(0 <= nextX && nextX < 5 && 0 <= nextY && nextY < 5){
                dfs(nextX*5 + nextY, nowValue * 10 + map[nextX][nextY], count+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        

        for(int i = 0; i < 5; i++){
            StringTokenizer token = new StringTokenizer(re.readLine());
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(i*5+j, map[i][j], 1);
            }
        }

        System.out.print(answer.size());
        re.close();
    }
}
