package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 커피숍2
// gold 1
public class b1275 {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);

        tree = new long[treeSize];
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }
        init(arr, 1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            sb.append(sum(1, 1, n, x, y)).append("\n");
            update(1, 1, n, a, b);
        }

        System.out.println(sb);
    }

    static long update(int node, int start, int end, int idx, int val) {
        if (idx < start || idx > end) {
            return tree[node];
        }
        if (start == end) {
            return tree[node] = val;
        }

        return tree[node] = update(node * 2, start, (start + end) / 2, idx, val) +
                update(node * 2 + 1, (start + end) / 2 + 1, end, idx, val);
    }

    static long sum(int node, int start, int end, int left, int right) {
        if (end < left || start > right) {
            return 0;
        }
        if (left <= start && right >= end) {
            return tree[node];
        }

        return sum(node * 2, start, (start + end) / 2, left, right) +
                sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    static long init(int[] arr, int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        return tree[node] = init(arr, node * 2, start, (start + end) / 2) +
                init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
    }
}
