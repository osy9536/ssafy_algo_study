package algorithm.src.ohseyoung;

import java.io.*;
import java.util.*;

// 구간 합 구하기
// gold 1
public class b2042 {

    static class Segment {
        long[] tree;
        int treeSize;

        public Segment(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, h + 1);
            tree = new long[treeSize];
        }

        /*
        node : 현재 노드
        start : arr 시작값
        end : arr 끝 값
         */
        long init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            }
            return tree[node] = init(node * 2, start, (start + end) / 2)
                    + init(node * 2 + 1, (start + end) / 2+1, end);
        }

        void update(int node, int start, int end, int idx, long diff) {
            if (idx < start || idx > end) return;
            tree[node] += diff;
            if (start != end) {
                update(node * 2, start, (start + end) / 2, idx, diff);
                update(node * 2 + 1, (start + end) / 2+1, end, idx, diff);
            }
        }

        long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            return sum(node * 2, start, (start + end) / 2, left, right) +
                    sum(node * 2 + 1, (start + end) / 2+1, end, left, right);
        }
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
                segment.update(1, 1, n, b, c - arr[b]);
                arr[b] = c;
            } else {
                bw.write(segment.sum(1, 1, n, b, (int)c)+"\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
