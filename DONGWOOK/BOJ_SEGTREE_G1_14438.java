package BOJ._06_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_SEGTREE_G1_14438 {
    static int N;
    static int[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[(N + 1) * 4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                update(1, 1, N, b, c);
                arr[b] = c;
            } else {
                int min = getMin(1, 1, N, b, c);
                sb.append(min + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    static int init(int node, int start, int end) {

        if (start == end) {
            return tree[node] = arr[start];
        } else {
            return tree[node] = Math.min(init(node * 2, start, (start + end) / 2)
                    , init(node * 2 + 1, (start + end) / 2 + 1, end));
        }
    }

    static int update(int node, int start, int end, int index, int changeValue) {
        if (index < start || end < index) {
            return tree[node];
        } else if (start == index && end == index) {
            return tree[node] = changeValue;
        } else {
            return tree[node] = Math.min(update(node * 2, start, (start + end) / 2, index, changeValue),
                    update(node * 2 + 1, (start + end) / 2 + 1, end, index, changeValue));
        }
    }

    static int getMin(int node, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return Integer.MAX_VALUE;
        } else if (left <= start && end <= right) {
            return tree[node];
        } else {
            return Math.min(getMin(node * 2, start, (start + end) / 2, left, right),
                    getMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
        }
    }
}
