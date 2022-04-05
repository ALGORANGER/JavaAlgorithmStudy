import java.util.*;
import java.io.*;

class Edge{
    int from;
    int to;
    int value;

    public Edge(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }
}

public class _BOJ_MST_G4_1197 {
    static int[] parent;

    static int find(int n){
        if(parent[n] == n)
            return n;
        else
            return parent[n] = find(parent[n]);
    }

    static boolean union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX == parentY)
            return false;

        if(parentX < parentY){
            parent[parentY] = parentX;
        }else{
            parent[parentX] = parentY;
        }

        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer token = new StringTokenizer(re.readLine());
            int node = Integer.parseInt(token.nextToken());
            int edge = Integer.parseInt(token.nextToken());

            parent = new int[node+1];
            Edge[] edges = new Edge[edge];
            for(int i = 0; i < node+1; i++)
                parent[i] = i;
            
            for(int j = 0; j < edge; j++){
                token = new StringTokenizer(re.readLine());
                int from = Integer.parseInt(token.nextToken());
                int to = Integer.parseInt(token.nextToken());
                int value = Integer.parseInt(token.nextToken());
                edges[j] = new Edge(from, to, value);
            }

            Arrays.sort(edges, (a,b)->{
                return Integer.compare(a.value, b.value);
            });

            int answer = 0;
            for(Edge iter : edges){
                if(union(iter.from, iter.to)){
                    answer += iter.value;
                }
            }
            
            System.out.print(answer);
        re.close();
    }
}
