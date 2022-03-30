import java.util.*;
import java.io.*;

public class _BOJ_DFS_S1_2667 {
    static final int[][] delta = {{0,1}, {1,0}, {-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(re.readLine());

        char[][] inputData = new char[n][];

        for(int i = 0; i < n; i++){
            inputData[i] = re.readLine().toCharArray();
        }

        List<Integer> answer = new ArrayList<>();
        Stack<Integer> dfs = new Stack<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(inputData[i][j] == '1'){
                    inputData[i][j] = '0';
                    int ans = 0;
                    dfs.add(i*n+j);


                    while(!dfs.isEmpty()){
                        int x = dfs.peek() / n;
                        int y = dfs.pop() % n;
                        ans++;

                        for(int k = 0; k < 4; k++){
                            int nextX = x + delta[k][0];
                            int nextY = y + delta[k][1];

                            if(0 <= nextX && nextX < n && 0 <= nextY && nextY < n && inputData[nextX][nextY] =='1'){
                                inputData[nextX][nextY] = '0';
                                dfs.add((nextX*n + nextY));
                            }
                        }
                    }

                    answer.add(ans);
                }
            }
        }
        answer.sort(null);
        StringBuilder a = new StringBuilder();
        a.append(answer.size()).append('\n');
        for(Integer i : answer){
            a.append(i).append('\n');
        }
        System.out.print(a);
        re.close();
    }
}
