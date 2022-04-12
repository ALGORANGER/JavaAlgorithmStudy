import java.util.*;
import java.io.*;

public class _BOJ_MST_G4_1922 {
    public static void main(String[] args) throws IOException {
        final int INF = 1_000_000_001;
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(re.readLine());
        int e = Integer.parseInt(re.readLine());

        int[][] inputData = new int[n+1][n+1];

        // 각 거리 INF로
        for(int i = 1; i < n+1; i++)
            Arrays.fill(inputData[i], INF);
        // 자기 자신은 거리 비용 0
        for(int i = 0; i < n+1; i++)
            inputData[i][i] = 0;

        // edge 입력받기
        for(int i = 0; i < e; i++){
            StringTokenizer token = new StringTokenizer(re.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());

            inputData[a][b] = Integer.min(value, inputData[a][b]);
            inputData[b][a] = Integer.min(value, inputData[b][a]);
        }

        boolean[] checked = new boolean[n+1];
        int connectedNode = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, (a,b)->{
            return Integer.compare(a[1], b[1]);
        });
        checked[1] = true;
        ++connectedNode;
        
        // 2번 노드랑 연결된 곳 priority queue에 넣기.
        for(int i = 2; i < n+1; i++){
            if(inputData[1][i] != INF){
                pq.add(new int[]{i, inputData[1][i]});
            }
        }

        int answer = 0;
        while(connectedNode < n && !pq.isEmpty()){
            int[] now = pq.poll();
            
            // 이미 추가한 거면 빼기.
            if(checked[now[0]])
                continue;

            // 비용 더하기
            answer += now[1];
            ++connectedNode;
            checked[now[0]] = true;
            
            // 새로 연결한 노드랑 연결된 곳 priority queue에 넣기.
            for(int i = 1; i < n+1; i++){
                if(inputData[now[0]][i] != INF && now[0] != i){
                    pq.add(new int[]{i, inputData[now[0]][i]});
                }
            }
            
        }
        System.out.print(answer);

        re.close();
    }
}
