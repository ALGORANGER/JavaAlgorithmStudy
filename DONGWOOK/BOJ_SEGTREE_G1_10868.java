package BOJ._06_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_SEGTREE_G1_10868 {
    static int N, M;
    static int[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        tree = new int[(N + 1) * 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = getMin(1, 1, N, a, b);
            sb.append(min + "\n");
        }
        System.out.println(sb.toString());
    }

    static int init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        } else {
            return tree[node] = Math.min(init(node * 2, start, (start + end) / 2),
                    init(node * 2 + 1, (start + end) / 2 + 1, end));
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
