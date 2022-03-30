import java.util.*;
import java.io.*;

public class _BOJ_DFS_G3_1941 {
    static final int[][] delta = {{0,1}, {1,0}, {-1,0},{0,-1}};

    // 이다솜파
    static boolean[] dasom = new boolean[25];

    // 칠공주
    static boolean[] selected = new boolean[25];
    
    // 칠공주 소속 학생 번호
    static List<Integer> princess = new ArrayList<>();
    
    static int ans = 0;
    // index, 현재 몇개.
    static void dfs(int index){
        if(princess.size() == 7){
            int dasomCnt = 0;

            // 다솜파가 몇명인지 세기
            for(int i : princess){
                if(dasom[i])
                    dasomCnt++;
            }
            if(dasomCnt < 4)
                return;

            // 다솜파끼리 붙어있는지 확인.
            boolean[] visited = new boolean[25];
            int connectCnt = 1;
            Queue<Integer> bfs = new ArrayDeque<>();
            bfs.add(princess.get(0));
            visited[princess.get(0)] = true;
            while(!bfs.isEmpty()){
                int x = bfs.peek() / 5;
                int y = bfs.poll() % 5;
                
                for(int i = 0; i < 4; i++){
                    int nextX = x + delta[i][0];
                    int nextY = y + delta[i][1];
                    int nextPos = nextX * 5 + nextY;

                    if(nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 && selected[nextPos] && !visited[nextPos]){
                        visited[nextPos] = true;
                        connectCnt++;
                        bfs.add(nextPos);
                    }
                }
            }

            if(connectCnt == 7)
                ans++;
        }else{
            for(int i = index; i < 25; i++){
                if(!selected[i]){
                    selected[i] = true;
                    princess.add(i);

                    dfs(i+1);

                    princess.remove(princess.size()-1);
                    selected[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        
        for(int i = 0; i < 5; i++){
            String s = re.readLine();
            for(int j = 0; j < 5; j++){
                if(s.charAt(j) == 'S'){
                    dasom[i*5+j] = true;
                }
            }
        }

        dfs(0);
        System.out.print(ans);
        re.close();        
    }
}
