package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최솟값
// gold 1
public class b10868 {

    static int treeSize;
    static long[] tree;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        treeSize = (int) Math.pow(2, h + 1);

        tree = new long[treeSize];

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(br.readLine());

            arr[i] = a;
        }

        init(arr, 1, 1, n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(find(1, 1, n, l, r)).append("\n");
        }

        System.out.print(sb);
    }

    static long init(int[] arr, int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        return tree[node] = Math.min(init(arr, node * 2, start, (start + end) / 2),
                init(arr, node * 2 + 1, (start + end) / 2 + 1, end));
    }

    static long find(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        return Math.min(find(node * 2, start, (start + end) / 2, left, right),
                find(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
    }
}
