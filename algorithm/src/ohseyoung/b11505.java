package algorithm.src.ohseyoung;

import java.io.*;
import java.util.StringTokenizer;

// 구간 곱 구하기
// gold 1
public class b11505 {
    static final int div = 1_000_000_007;

    static class Segment {
        long[] tree;
        int treeSize;

        Segment(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            treeSize = (int) Math.pow(2, h + 1);
            tree = new long[treeSize];
        }

        long init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            }
            return tree[node] = (init(node * 2, start, (start + end) / 2) *
                    init(node * 2 + 1, (start + end) / 2 + 1, end)) % div;
        }

        long update(int node, int start, int end, int idx, long val) {
            if (idx < start || idx > end) return tree[node];
            if (start == end) {
                return tree[node] = val;
            }
            return tree[node] = (update(node * 2, start, (start + end) / 2, idx, val) *
                    update(node * 2 + 1, (start + end) / 2 + 1, end, idx, val)) % div;
        }

        long mul(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 1;

            if (left <= start && end <= right) {
                return tree[node];
            }

            return (mul(node * 2, start, (start + end) / 2, left, right) *
                    mul(node * 2 + 1, (start + end) / 2 + 1, end, left, right)) % div;
        }
        // 4 -> 6
        // 10, 40 -> 60
        // 5, 200 -> 300
        // 4*6*7*11 % 3
        // 1868 = 2
        // 1*0*1*2
    }

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i] = num;
        }
        Segment segment = new Segment(n);
        segment.init(1, 1, n);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                arr[b] = c;
                segment.update(1, 1, n, b, c);
            } else {
                bw.write(segment.mul(1, 1, n, b, (int) c) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
