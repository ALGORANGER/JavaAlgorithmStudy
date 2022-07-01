package BOJ._06_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_SEGTREE_P4_16975 {
    static int N;
    static long[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        tree = new long[(N + 1) * 4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                update(1, 1, N, b, c, d);
            } else {
                int b = Integer.parseInt(st.nextToken());
                long n = arr[b]+getNumber(1, 1, N, b, 0);
                sb.append(n + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void update(int node, int start, int end, int left, int right, int k) {
        if (end < left || right < start) {
            return;
        } else if (left <= start && end <= right) {
            tree[node] += k;
        } else {
            update(node * 2, start, (start + end) / 2, left, right, k);
            update(node * 2 + 1, (start + end) / 2 + 1, end, left, right, k);
        }
    }

    static long getNumber(int node, int start, int end, int index, long sum) {
        if (index < start || end < index) {
            return 0;
        } else if (start == index && end == index) {
            return tree[node] + sum;
        } else {
            long a = getNumber(node * 2, start, (start + end) / 2, index, sum + tree[node]);
            long b = getNumber(node * 2 + 1, (start + end) / 2 + 1, end, index, sum + tree[node]);
            if (a != 0) {
                return a;
            } else {
                return b;
            }
        }
    }
}

