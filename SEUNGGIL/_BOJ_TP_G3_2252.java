import java.util.*;
import java.io.*;

public class _BOJ_TP_G3_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token = new StringTokenizer(re.readLine());
        int studentCnt = Integer.parseInt(token.nextToken());
        int edgeCnt = Integer.parseInt(token.nextToken());

        // 진입 차수
        int[] students = new int[studentCnt+1];
        

        // 연결된 간선
        List<List<Integer>> edges = new ArrayList<>((int)1.4 * studentCnt);

        for(int i = 0; i <= studentCnt; i++){
            edges.add(new ArrayList<>());
        }
        for(int i = 0; i < edgeCnt; i++){
            token = new StringTokenizer(re.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            edges.get(from).add(to);
            students[to]++;
        }

        Queue<Integer> bfs = new ArrayDeque<>();

        for(int i = 1; i <= studentCnt; i++){
            if(students[i] == 0)
                bfs.add(i);
        }

        StringBuilder ans = new StringBuilder();
        while(!bfs.isEmpty()){
            int now = bfs.poll();
            ans.append(now).append(' ');

            for(int iter : edges.get(now)){
                if(--students[iter] == 0)
                    bfs.add(iter);
            }
        }

        System.out.print(ans);
        re.close();
    }
}
