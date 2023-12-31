package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합 7
// gold 1
public class b2268 {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);

        tree = new long[treeSize];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            boolean a = st.nextToken().equals("0");
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a) {
                if (b > c) {
                    int temp = b;
                    b = c;
                    c = temp;
                }
                sb.append(sum(1, 1, n, b, c)).append("\n");
            } else {
                modify(1, 1, n, b, c);
            }
        }
        System.out.print(sb);
    }

    static long modify(int node, int start, int end, int idx, int val) {
        if (idx < start || idx > end) {
            return tree[node];
        }
        if (start == end) {
            return tree[node] = val;
        }

        return tree[node] = modify(node * 2, start, (start + end) / 2, idx, val) +
                modify(node * 2 + 1, (start + end) / 2 + 1, end, idx, val);
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
}
