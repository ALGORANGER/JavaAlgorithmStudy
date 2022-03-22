import java.util.*;
import java.io.*;

public class _BOJ_DFS_S3_15270 {
    static List<List<Integer>> relations;
    static boolean[] select;
    static int cnt = 0;
    static int ans = 0;
    static void dfs(int index, int now){
        ans = Math.max(cnt+1,ans);
        if(index >= relations.size())
            return;
        
        for(int i = index; i < relations.size(); i++){
            if(!select[i]){
                select[i] = true;
                cnt++;
                for (int friend : relations.get(i)) {
                    if(!select[friend]){
                        select[friend] = true;
                        cnt++;

                        dfs(i+1,now+2);

                        cnt--;
                        select[friend] = false;
                    }
                }
                cnt--;
                select[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token = new StringTokenizer(re.readLine());

        int friendCnt = Integer.parseInt(token.nextToken());
        int relationCnt = Integer.parseInt(token.nextToken());

        relations = new ArrayList<>();
        select = new boolean[friendCnt+1];

        for(int i = 0; i <= friendCnt; i++){
            relations.add(new LinkedList<>());
        }

        for(int i = 0; i < relationCnt; i++){
            token = new StringTokenizer(re.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            relations.get(a).add(b);
            relations.get(b).add(a);
        }

        
        dfs(1,0);
        if(ans > friendCnt)
            System.out.print(friendCnt);
        else
            System.out.print(ans);

        re.close();
    }
}
