package BOJ._06_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_SEGTREE_G1_11505 {
    static int N, num = 1000000007;
    static int[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        Arrays.fill(arr, 1);
        tree = new int[(N + 1) * 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                update(1, 1, N, b, c);
                arr[b] = c;
            } else {
                int m = multi(1, 1, N, b, c);
                sb.append(m + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    static int init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        } else {
            long temp = ((long) init(node * 2, start, (start + end) / 2) % num
                    * (long) init(node * 2 + 1, (start + end) / 2 + 1, end) % num) % num;
            return tree[node] = (int) temp;
        }
    }

    static int update(int node, int start, int end, int index, int changeValue) {
        if (index < start || end < index) {
            return tree[node];
        } else if (start == index && end == index) {
            return tree[node] = changeValue;
        } else {
            long temp = ((long)update(node * 2, start, (start + end) / 2, index, changeValue) % num
                    * (long)update(node * 2 + 1, (start + end) / 2 + 1, end, index, changeValue) % num) % num;
            return tree[node] = (int) temp;
        }
    }

    static int multi(int node, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return 1;
        } else if (left <= start && end <= right) {
            return tree[node];
        } else {
            long temp = ((long)multi(node * 2, start, (start + end) / 2, left, right) % num
                    * (long)multi(node * 2 + 1, (start + end) / 2 + 1, end, left, right) % num) % num;
            return (int) temp;
        }
    }
}
