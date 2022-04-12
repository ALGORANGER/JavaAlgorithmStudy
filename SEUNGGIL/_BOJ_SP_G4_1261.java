import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int to;
    int length;

    public Edge(int to, int length) {
        this.to = to;
        this.length = length;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(length, o.length);
    }

}
public class _BOJ_SP_G4_1261 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        final int INF = 100001;
        final int[] dx = {0, 1, -1, 0};
        final int[] dy = {1, 0, 0,-1};

        ArrayDeque<Integer> a = new ArrayDeque<>();
        
        StringTokenizer token = new StringTokenizer(re.readLine());

        int m = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());

        int[][] map = new int[n][m];
        
        for(int i = 0; i < n; i++){
            String s = re.readLine();
            for(int j = 0; j < m; j++){
                if(s.charAt(j) == '0')
                map[i][j] = 0;
                else
                map[i][j] = 1;
            }
        }
        
        int[] distance = new int[n*m];
        boolean[] check = new boolean[n*m];

        Arrays.fill(distance, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0,0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            int to = now.to;
            int length = now.length;
            
            if(check[to])
                continue;
            
            check[to] = true;
            distance[to] = length;

            int x = to / m;
            int y = to % m;
            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !check[nextX*m + nextY]){
                    pq.add(new Edge(nextX*m + nextY, length + map[nextX][nextY]));
                }
            }
        }
        
        System.out.print(distance[n*m-1]);
        
        re.close();
    }
}
