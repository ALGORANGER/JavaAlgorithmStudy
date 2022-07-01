package BOJ._06_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_SEGTREE_G1_14428 {
    static class Node {
        int no, index;

        public Node(int no, int index) {
            this.no = no;
            this.index = index;
        }
    }

    static int N;
    static Node[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node[N + 1];
        tree = new Node[(N + 1) * 4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            Node node = new Node(Integer.parseInt(st.nextToken()), i);
            arr[i] = node;
        }
        int M = Integer.parseInt(br.readLine());
        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                update(1, 1, N, b, c);
                arr[b].no = c;
            } else {
                Node node = getMin(1, 1, N, b, c);
                sb.append(node.index + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    static Node init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        } else {
            Node A = init(node * 2, start, (start + end) / 2);
            Node B = init(node * 2 + 1, (start + end) / 2 + 1, end);
            int a = A.no;
            int b = B.no;

            if (b < a) {
                return tree[node] = B;
            } else {
                return tree[node] = A;
            }

        }
    }

    static Node update(int node, int start, int end, int index, int changeValue) {
        if (index < start || end < index) {
            return tree[node];
        } else if (start == index && end == index) {
            Node changeNode = new Node(changeValue, index);
            return tree[node] = changeNode;
        } else {
            Node A = update(node * 2, start, (start + end) / 2, index, changeValue);
            Node B = update(node * 2 + 1, (start + end) / 2 + 1, end, index, changeValue);
            int a = A.no;
            int b = B.no;
            if (b < a) {
                return tree[node] = B;
            } else {
                return tree[node] = A;
            }
        }
    }

    static Node getMin(int node, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return new Node(Integer.MAX_VALUE, -1);
        } else if (left <= start && end <= right) {
            return tree[node];
        } else {
            Node A = getMin(node * 2, start, (start + end) / 2, left, right);
            Node B = getMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            int a = A.no;
            int b = B.no;
            if (b < a) {
                return B;
            } else {
                return A;
            }
        }
    }
}
