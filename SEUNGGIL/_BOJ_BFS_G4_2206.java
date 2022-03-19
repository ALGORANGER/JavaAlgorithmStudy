import java.util.*;
import java.io.*;

public class _BOJ_BFS_G4_2206 {
    static final int[][] delta = {{0,1}, {1,0}, {-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(re.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        // true면 벽
        boolean wallMap[][] = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String s = re.readLine();
            for(int j = 0; j < m; j++){
                if(s.charAt(j) == '1'){
                    wallMap[i][j] = true;
                }
            }
        }
        
        int [][] normalMap = new int[n][m];
        int [][] brokenMap = new int[n][m];

        Queue<Integer> normalQueue = new ArrayDeque<>();
        Queue<Integer> brokenQueue = new ArrayDeque<>();

        normalQueue.offer(0);
        normalMap[0][0] = 1;

        while(!normalQueue.isEmpty()){
            int x = normalQueue.poll();
            int y = x % m;
            x /= m;

            for(int i = 0; i < 4; i++){
                int nextX = x + delta[i][0];
                int nextY = y + delta[i][1];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                    continue;
                
                if(wallMap[nextX][nextY]){
                    if(brokenMap[nextX][nextY] == 0){
                        brokenMap[nextX][nextY] = normalMap[x][y] + 1;
                        brokenQueue.add(nextX*m + nextY);
                    }
                    
                }else{
                    if(normalMap[nextX][nextY] == 0){
                        normalMap[nextX][nextY] = normalMap[x][y] + 1;
                        normalQueue.add(nextX*m + nextY);
                    }
                }
            }
        }
        while(!brokenQueue.isEmpty()){
            int x = brokenQueue.poll();
            int y = x % m;
            x /= m;

            for(int i = 0; i < 4; i++){
                int nextX = x + delta[i][0];
                int nextY = y + delta[i][1];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                    continue;
                
                if(!wallMap[nextX][nextY] && (brokenMap[nextX][nextY] == 0 || brokenMap[nextX][nextY] > brokenMap[x][y] + 1)){
                    brokenMap[nextX][nextY] = brokenMap[x][y] + 1;
                    brokenQueue.add(nextX*m + nextY);
                }
            }
        }
        int answer = Integer.MAX_VALUE;

        if(normalMap[n-1][m-1] != 0)
            answer = Math.min(answer, normalMap[n-1][m-1]);
        if(brokenMap[n-1][m-1] != 0)
            answer = Math.min(answer, brokenMap[n-1][m-1]);

        if(answer == Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(answer);
        re.close();        
    }
}
