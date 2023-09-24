package algorithm.src.ohseyoung;

import java.io.*;
import java.util.StringTokenizer;

// 최솟값과 최댓값
// gold 1
public class b2357 {

    static class SegmentTree {
        int[] maxTree;
        int[] minTree;
        int treeSize;

        SegmentTree(int arraySize) {
            int h = (int) Math.ceil(Math.log(arraySize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, h + 1);
            maxTree = new int[treeSize];
            minTree = new int[treeSize];
        }

        int maxInit(int[] arr, int node, int start, int end) {
            if (start == end) {
                maxTree[node] = arr[start];
            } else maxTree[node] = Math.max(maxInit(arr, node * 2, start, (start + end) / 2)
                    , maxInit(arr, node * 2 + 1, (start + end) / 2 + 1, end));
            return maxTree[node];
        }

        int minInit(int[] arr, int node, int start, int end) {
            if (start == end) {
                minTree[node] = arr[start];
            }
            else minTree[node] = Math.min(minInit(arr, node * 2, start, (start + end) / 2)
                    , minInit(arr, node * 2 + 1, (start + end) / 2 + 1, end));
            return minTree[node];
        }

        int maxSearch(int node, int left, int right, int start, int end) {
            if (left > end || right < start) return Integer.MIN_VALUE;

            if (left <= start && end <= right) {
                return maxTree[node];
            }
            int mid = (start + end) / 2;
            return Math.max(maxSearch(node * 2, left, right, start, mid),
                    maxSearch(node * 2 + 1, left, right, mid + 1, end));
        }

        int minSearch(int node, int left, int right, int start, int end) {
            if (left > end || right < start) return Integer.MAX_VALUE;

            if (left <= start && end <= right) {
                return minTree[node];
            }
            int mid = (start + end) / 2;
            return Math.min(minSearch(node * 2, left, right, start, mid),
                    minSearch(node * 2 + 1, left, right, mid + 1, end));
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(br.readLine());
            nums[i] = a;
        }

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.maxInit(nums, 1, 1, N);
        segmentTree.minInit(nums, 1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int max = segmentTree.maxSearch(1, a, b, 1, N);
            int min = segmentTree.minSearch(1, a, b, 1, N);
            bw.write(min + " " + max+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
