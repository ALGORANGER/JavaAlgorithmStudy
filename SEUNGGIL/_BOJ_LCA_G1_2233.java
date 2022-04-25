import java.util.*;
import java.io.*;

public class _BOJ_LCA_G1_2233 {
    public static void main(String[] args) throws Exception {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(re.readLine());

        int[] depth = new int[n];
        int[] parent = new int[n];
        
        // 각 위치가 몇번 노드를 나타내는지.
        int[] node = new int[2*n];
        
        int nowDepth = 0;

        // 현재 바라보고 있는 노드
        int nowNode = 0;

        // 다음에 새로 추가할 노드
        int nextNode = 1;
        
        String inputData = re.readLine();
        node[0] = 0;

        for (int i = 1, length = 2*n -1; i < length; i++) {
            char c = inputData.charAt(i);
            if(c == '0'){
                //children[nowNode].add(nextNode);
                parent[nextNode] = nowNode;
                node[i] = nextNode;

                nowDepth++;
                depth[nextNode] = nowDepth;
                nowNode = nextNode++;
            }else{
                node[i] = nowNode;
                nowNode = parent[nowNode];
                nowDepth--;
            }

        }

        StringTokenizer token = new StringTokenizer(re.readLine());
        int a = Integer.parseInt(token.nextToken()) - 1;
        int b = Integer.parseInt(token.nextToken()) - 1;

        int nodeA = node[a];
        int nodeB = node[b];

        while(nodeA != nodeB){
            if(depth[nodeA] == depth[nodeB]){
                nodeA = parent[nodeA];
                nodeB = parent[nodeB];
            }else if(depth[nodeA] > depth[nodeB]){
                nodeA = parent[nodeA];
            }else{
                nodeB = parent[nodeB];
            }
        }

        StringBuilder ans = new StringBuilder(5);
        for(int i = 0; i < node.length; i++){
            if(node[i] == nodeA){
                ans.append(i+1).append(' ');
            }
        }
        System.out.print(ans);
        re.close();
    }
}
