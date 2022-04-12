import java.util.*;
import java.io.*;

class Pos{
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}

public class BOJ_BFS_G5_14502 {
    static final int[] dx = {0, 1, -1, 0};
    static final int[] dy = {1, 0, 0,-1};

    static int startSafeArea;
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token = new StringTokenizer(re.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[][] map = new int[n][m];

        startSafeArea = 0;
        List<Pos> virusList = new ArrayList<>();
        List<Pos> blankList = new ArrayList<>();
        List<Pos> wallList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            token = new StringTokenizer(re.readLine());
            for(int j = 0; j < m; j++){
                int type = Integer.parseInt(token.nextToken());
                map[i][j] = type;

                if(type == 0){
                    blankList.add(new Pos(i,j));
                    ++startSafeArea;
                }else if(type == 1){
                    wallList.add(new Pos(i,j));
                }else{
                    virusList.add(new Pos(i,j));
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < blankList.size(); i++){
            for(int j = i+1; j < blankList.size(); j++){
                for(int k = j+1; k < blankList.size(); k++){
                    Pos a = blankList.get(i);
                    Pos b = blankList.get(j);
                    Pos c = blankList.get(k);

                    boolean[][] visited = new boolean[n][m];

                    visited[a.x][a.y] = true;
                    visited[b.x][b.y] = true;
                    visited[c.x][c.y] = true;

                    answer = Integer.max(answer , bfs(map,visited,virusList));

                    visited[a.x][a.y] = false;
                    visited[b.x][b.y] = false;
                    visited[c.x][c.y] = false;
                }
            }
        }
        System.out.print(answer);
        re.close();
    }

    static int bfs(int[][] map, boolean[][] visited, List<Pos> virusList){
        int answer = startSafeArea - 3;

        Queue<Pos> bfs = new ArrayDeque<>();

        for(Pos iter : virusList){
            bfs.add(iter);
        }
            

        while(!bfs.isEmpty()){
            Pos now = bfs.poll();

            for(int i = 0; i < 4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if((x >= 0) && (x < map.length) && y >= 0 && (y < map[0].length) && map[x][y] == 0 && !visited[x][y]){
                    visited[x][y] = true;
                    answer--;
                    bfs.add(new Pos(x,y));
                }
            }
        }
        
        return answer;
    }
}
