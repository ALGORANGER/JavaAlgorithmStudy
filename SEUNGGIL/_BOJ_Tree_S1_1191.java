import java.util.*;
import java.io.*;

public class _BOJ_Tree_S1_1191 {
    static Node[] inputData;
    static StringBuilder ans = new StringBuilder();

    static class Node{
        int left;
        int right;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(re.readLine());
        
        inputData = new Node[n];
        for(int i = 0; i < n; i++){
            StringTokenizer token = new StringTokenizer(re.readLine());
            
            char c = token.nextToken().charAt(0);
            char left = token.nextToken().charAt(0);
            char right = token.nextToken().charAt(0);
            
            inputData[c-'A'] = new Node(30,30);
            if(left != '.'){
                inputData[c-'A'].left = left - 'A';
            }
            if(right != '.'){
                inputData[c-'A'].right = right - 'A';
            }
        }

        
        // 전위 순회
        Stack<Integer> dfs = new Stack<>();
        dfs.add(0);
        while(!dfs.isEmpty()){
            int now = dfs.pop();
            ans.append((char)(now+'A'));
            if(inputData[now].right != 30)
                dfs.add(inputData[now].right);
            if(inputData[now].left != 30)
                dfs.add(inputData[now].left); 
        }
        ans.append('\n');

        // 중위 순회
        printInorder(0);
        ans.append('\n');

        // 후위 순회
        printPostOrder(0);

        // for(int i = 0; i < n; i++){
        //     System.out.println(i + " " + inputData[i].left + " " + inputData[i].right);
        // }
        System.out.print(ans);
        re.close();
    }

    static void printInorder(int now){
        if(inputData[now].left != 30)
            printInorder(inputData[now].left); 
        ans.append((char)(now+'A'));

        if(inputData[now].right != 30)
            printInorder(inputData[now].right);
            
    }

    static void printPostOrder(int now){
        if(inputData[now].left != 30)
            printPostOrder(inputData[now].left); 
        
        if(inputData[now].right != 30)
            printPostOrder(inputData[now].right);
        ans.append((char)(now+'A'));
    }
}
