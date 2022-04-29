import java.util.*;
import java.io.*;

public class _BOJ_TP_G2_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token = new StringTokenizer(re.readLine());
        int singerCnt = Integer.parseInt(token.nextToken());
        int pdCnt = Integer.parseInt(token.nextToken());

        // 진입 차수
        int[] singers = new int[singerCnt+1];
        

        // 연결된 간선
        List<List<Integer>> edges = new ArrayList<>((int)1.4 * singerCnt);

        for(int i = 0; i <= singerCnt; i++){
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i < pdCnt; i++){
            token = new StringTokenizer(re.readLine());
            int n = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());
            for(int j = 1; j < n; j++){
                int to = Integer.parseInt(token.nextToken());
                
                edges.get(from).add(to);
                singers[to]++;

                from = to;
            }    
        }

        Queue<Integer> bfs = new ArrayDeque<>();

        for(int i = 1; i <= singerCnt; i++){
            if(singers[i] == 0)
                bfs.add(i);
        }
        int visitCnt = 0;
        StringBuilder ans = new StringBuilder();
        while(!bfs.isEmpty()){
            int now = bfs.poll();
            visitCnt++;
            ans.append(now).append('\n');

            for(int iter : edges.get(now)){
                if(--singers[iter] == 0)
                    bfs.add(iter);
            }
        }

        if(visitCnt == singerCnt)
            System.out.print(ans);
        else
            System.out.print(0);
        re.close();
    }
}
