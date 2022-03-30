import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class customLinkedList<E>{
    public int length = 0;
    Node<E> start = null;
    Node<E> end = null;
    
    Node<E> add(E value){
        if(length == 0){
            start = new Node<E>(value);
            end = start;
            length++;
        }else{
            end.right = new Node<E>(value);
            end.right.left = end;
            end = end.right;
            length++;
        }

        return end;
    }

    E front(){
        if(start == null)
            return null;
        else
            return start.value;
    }
    E back(){
        if(end == null)
            return null;
        else
            return end.value;
    }

    void remove(Node<E> iter){
        if(length == 1){
            start = null;
            end = null;
        }else{
            Node<E> beforeNode = iter.left;
            Node<E> afterNode = iter.right;
            
            if(beforeNode == null){
                start = afterNode;
                start.left = null;
            }
            else if(afterNode == null){
                end = beforeNode;
                end.right = null;
            }else{
                beforeNode.right = afterNode;
                afterNode.left = beforeNode;
            }
        }
        length--;
        
    }

}
class Node<E>{
    public E value;
    public Node<E> left = null;
    public Node<E> right = null;

    Node (E value){
        this.value = value;
    }
}

public class _BOJ_DC_G4_2374 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        customLinkedList<Integer> inputData = new customLinkedList<>();
        TreeMap<Integer,ArrayList<Node<Integer>>> tree = new TreeMap<>();
        
        int n = Integer.parseInt(re.readLine());

        for(int i = 0; i < n; i++){
            Integer num = Integer.parseInt(re.readLine());
            if(num != inputData.back()){
                Node<Integer> iter = inputData.add(num);
                ArrayList<Node<Integer>> nodeList = tree.getOrDefault(num, new ArrayList<>());
                nodeList.add(iter);
                tree.put(num, nodeList);
            }
        }

        long answer = 0;
        for(Entry<Integer, ArrayList<Node<Integer>>> iter : tree.entrySet()){
            int num = iter.getKey();
            ArrayList<Node<Integer>> nodeList = iter.getValue();
            
            for(Node<Integer> node : nodeList){
                int i = Integer.MAX_VALUE;
                if(node.left != null)
                    i = node.left.value;
                if(node.right != null)
                    i = Math.min(i, node.right.value);
                
                if(i != Integer.MAX_VALUE){
                    answer += Math.abs(num-i);
                    inputData.remove(node);
                }
            }
        }

        System.out.print(answer);

        re.close();
    }
}
