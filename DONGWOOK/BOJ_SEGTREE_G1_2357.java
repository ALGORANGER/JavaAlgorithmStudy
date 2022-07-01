package BOJ._06_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_SEGTREE_G1_2357 {
    static int N;
    static int[] minTree, maxTree, arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        minTree = new int[(N + 1) * 4];
        maxTree = new int[(N + 1) * 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, N, 0);
        init(1, 1, N, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = getNumber(1, 1, N, a, b, 0);
            int max = getNumber(1, 1, N, a, b, 1);
            sb.append(min + " " + max + "\n");
        }
        System.out.println(sb.toString());
    }

    static int init(int node, int start, int end, int mode) {
        if (start == end) {
            if (mode == 0) {
                return minTree[node] = arr[start];
            } else {
                return maxTree[node] = arr[start];
            }
        } else {
            if (mode == 0) {
                return minTree[node] = Math.min(init(node * 2, start, (start + end) / 2, mode)
                        , init(node * 2 + 1, (start + end) / 2 + 1, end, mode));
            } else {
                return maxTree[node] = Math.max(init(node * 2, start, (start + end) / 2, mode)
                        , init(node * 2 + 1, (start + end) / 2 + 1, end, mode));
            }
        }
    }

    static int getNumber(int node, int start, int end, int left, int right, int mode) {
        if (end < left || right < start) {
            if (mode == 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (left <= start && end <= right) {
            if (mode == 0) {
                return minTree[node];
            } else {
                return maxTree[node];
            }
        } else {
            if (mode == 0) {
                return Math.min(getNumber(node * 2, start, (start + end) / 2, left, right, mode)
                        , getNumber(node * 2 + 1, (start + end) / 2 + 1, end, left, right, mode));
            } else {
                return Math.max(getNumber(node * 2, start, (start + end) / 2, left, right, mode)
                        , getNumber(node * 2 + 1, (start + end) / 2 + 1, end, left, right, mode));
            }
        }
    }
}
