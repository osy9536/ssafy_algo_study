package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 음주코딩
// gold 1
public class b5676 {

    static long[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);

                int n = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                int h = (int) Math.ceil(Math.log(n) / Math.log(2));
                int treeSize = (int) Math.pow(2, h + 1);

                tree = new long[treeSize];
                int[] arr = new int[n + 1];
                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= n; i++) {
                    int a = Integer.parseInt(st.nextToken());
                    a = Integer.compare(a, 0);
                    arr[i] = a;
                }
                init(arr, 1, 1, n);

                sb = new StringBuilder();
                for (int i = 0; i < q; i++) {
                    st = new StringTokenizer(br.readLine());
                    char x = st.nextToken().charAt(0);
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    if (x == 'C') {
                        b = Integer.compare(b, 0);
                        update(1, 1, n, a, b);
                    } else {
                        long temp = mul(1, 1, n, a, b);

                        sb.append(temp == 0 ? 0 : temp == 1 ? "+" : "-");
                    }
                }
                sb.append("\n");
                System.out.print(sb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static long update(int node, int start, int end, int idx, int val) {
        if (idx < start || idx > end) {
            return tree[node];
        }
        if (start == end) {
            return tree[node] = val;
        }

        return tree[node] = update(node * 2, start, (start + end) / 2, idx, val) *
                update(node * 2 + 1, (start + end) / 2 + 1, end, idx, val);
    }

    static long mul(int node, int start, int end, int left, int right) {
        if (end < left || start > right) {
            return 1;
        }
        if (left <= start && right >= end) {
            return tree[node];
        }

        return mul(node * 2, start, (start + end) / 2, left, right) *
                mul(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    static long init(int[] arr, int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        return tree[node] = init(arr, node * 2, start, (start + end) / 2) *
                init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
    }
}
