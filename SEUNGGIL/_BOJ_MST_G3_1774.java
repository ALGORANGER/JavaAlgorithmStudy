import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{

    int to;
    double len;
    public Edge(int to, double len) {
        this.to = to;
        this.len = len;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(len, o.len);
    }
    
}
public class _BOJ_MST_G3_1774 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(re.readLine());
        int n = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());

        double[][] inputData = new double[n+1][n+1];

        ArrayList<double[]> gods = new ArrayList<>();
        gods.add(new double[]{0,0});

        // 신 위치 입력받기.
        for(int godIdx = 1; godIdx <= n; godIdx++){
            token = new StringTokenizer(re.readLine());
            double x = Double.parseDouble(token.nextToken());
            double y = Double.parseDouble(token.nextToken());

            for(int j = 1; j < gods.size(); j++){
                double[] anotherGod = gods.get(j);
                double len = (Math.sqrt(Math.pow((anotherGod[0]-x),2) + Math.pow((anotherGod[1]-y),2)));
                
                inputData[godIdx][j] = len;
                inputData[j][godIdx] = len;
            }

            gods.add(new double[]{x,y});
        }

        // edge 입력받기
        for(int i = 0; i < e; i++){
            token = new StringTokenizer(re.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            inputData[a][b] = 0;
            inputData[b][a] = 0;
        }

        boolean[] checked = new boolean[n+1];
        int connectedNode = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(n);
        checked[1] = true;
        ++connectedNode;
        
        // 2번 노드랑 연결된 곳 priority queue에 넣기.
        for(int i = 2; i < n+1; i++){
            pq.add(new Edge(i, inputData[1][i]));
        }

        double answer = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            
            // 이미 추가한 거면 빼기.
            if(checked[now.to]){
                continue;
            }
            
            ++connectedNode;

            // 비용 더하기
            answer += now.len;
            checked[now.to] = true;
            
            if(connectedNode == n)
                break;

            // 새로 연결한 노드랑 연결된 곳 priority queue에 넣기.
            for(int i = 1; i < n+1; i++){
                if(now.to != i){
                    pq.add(new Edge(i, inputData[now.to][i]));
                }
            }
            
        }
        System.out.printf("%.2f",answer);

        re.close();
    }
}
