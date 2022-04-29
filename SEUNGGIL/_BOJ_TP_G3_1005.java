import java.util.*;
import java.io.*;

public class _BOJ_TP_G3_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(re.readLine());
        StringBuilder ans = new StringBuilder();
        for(int t = 1; t <= testCase; t++){
            StringTokenizer token = new StringTokenizer(re.readLine());
            int buildingCnt = Integer.parseInt(token.nextToken());
            int buildOrderCnt = Integer.parseInt(token.nextToken());

            // 진입 차수
            int[] building = new int[buildingCnt+1];
            // 건물별 건설 소요시간
            int[] buildTime = new int[buildingCnt+1];

            // 연결된 간선
            List<List<Integer>> buildOrder = new ArrayList<>((int)1.4 * buildingCnt);

            for(int i = 0; i <= buildingCnt; i++){
                buildOrder.add(new ArrayList<>());
            }

            token = new StringTokenizer(re.readLine());
            for(int i = 1; i <= buildingCnt; i++){
                buildTime[i] = Integer.parseInt(token.nextToken());
            }

            for(int i = 0; i < buildOrderCnt; i++){
                token = new StringTokenizer(re.readLine());
                int from = Integer.parseInt(token.nextToken());
                int to = Integer.parseInt(token.nextToken());

                buildOrder.get(from).add(to);
                building[to]++;
            }

            // 각 건물 완성 시간
            int[] buildFinishTime = new int[buildingCnt+1];
            Queue<Integer> bfs = new ArrayDeque<>();

            for(int i = 1; i <= buildingCnt; i++){
                if(building[i] == 0)
                    bfs.add(i);
            }
            while(!bfs.isEmpty()){
                int now = bfs.poll();
                // buildFinishTime에는 건설 시작 시간이 기록되어 있으니
                // 건설 시간만 더해주면 됨.
                buildFinishTime[now] += buildTime[now];

                for(int iter : buildOrder.get(now)){
                    // 건설 시작 시간을 적자.
                    if(buildFinishTime[iter] < buildFinishTime[now]){
                        // 요구 건물 중 가장 늦게 끝나는 시간으로 업데이트.
                        buildFinishTime[iter] = buildFinishTime[now];
                    }
                    if(--building[iter] == 0)
                        bfs.add(iter);
                }
            }
            int w = Integer.parseInt(re.readLine());
            ans.append(buildFinishTime[w]).append('\n');
        }
        System.out.println(ans);
        re.close();
    }
}
