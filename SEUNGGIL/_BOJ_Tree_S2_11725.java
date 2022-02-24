import java.util.*;
import java.io.*;

public class _BOJ_Tree_S2_11725 {
    static class Node{
        List<Integer> children = new ArrayList<>();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(re.readLine());

        Node[] inputData = new Node[n+1];
        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            inputData[i] = new Node();
        }
        for(int i = 1; i < n; i++){
            StringTokenizer token = new StringTokenizer(re.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            inputData[a].children.add(b);
            inputData[b].children.add(a);
        }

        parent[1] = 1;
        Stack<Integer> dfs = new Stack<>();

        dfs.add(1);

        while(!dfs.empty()){
            int p = dfs.pop();
            for (int i : inputData[p].children) {
                if(parent[i] == 0){
                    parent[i] = p;
                    dfs.add(i);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 2; i < n + 1; i++){
            ans.append(parent[i]).append('\n');
        }
        System.out.print(ans);
        re.close();
    }
}
