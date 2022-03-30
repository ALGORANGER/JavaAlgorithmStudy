import java.util.*;
import java.io.*;

public class _BOJ_DFS_S2_2529 {
    static boolean[] larger;
    static int n;
    static List<Long> ans = new ArrayList<>();
    static boolean[] use = new boolean[10];

    static void dfs(long now, int index){
        if(index == n){
            ans.add(now);
            return;
        }
        
        for(int i = 0; i < 10; i++){
            if(!use[i]){
                if(larger[index]){
                    if(now % 10 < i){
                        use[i] = true;
                        dfs(now*10+i, index+1);
                        use[i] = false;
                    }
                }else{
                    if(now % 10 > i){
                        use[i] = true;
                        dfs(now*10+i, index+1);
                        use[i] = false;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(re.readLine());
        larger = new boolean[n];

        StringTokenizer token = new StringTokenizer(re.readLine());
        for(int i = 0; i < n; i++){
            larger[i] = token.nextToken().equals(">") ? false : true;
        }

        for(int i = 0; i < 10; i++){
            use[i] = true;
            dfs(i,0);
            use[i] = false;
        }

        ans.sort(null);
        System.out.println(String.format("%0"+(n+1)+'d', ans.get(ans.size()-1)));
        System.out.print(String.format("%0"+(n+1)+'d', ans.get(0)));
        re.close();
    }
}
