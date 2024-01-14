package algorithm.src.ohseyoung;

import java.io.*;
import java.util.StringTokenizer;

// 수열과 쿼리 16
// gold 1
public class b14428 {

    static class Node{
        int val,idx;
        Node(int val, int idx){
            this.val=val;
            this.idx=idx;
        }
    }

    static class SegmentTree {

        Node[] tree;
        int treeSize;

        public SegmentTree(int arrSize) {

            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));

            this.treeSize = (int) Math.pow(2, h + 1);
            tree = new Node[treeSize];
            for(int i = 0; i<arrSize; i++) {
                tree[i] = new Node(Integer.MAX_VALUE,0);
            }
        }

        public Node init(int[] arr, int node, int start, int end) {

            if (start == end) {
                return tree[node] = new Node(arr[start],start);
            }
            Node a =init(arr, node * 2, start, (start + end) / 2);
            Node b= init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
            if(a.val>b.val){
                return tree[node] = new Node(b.val, b.idx);
            }else if(a.val==b.val){
                return tree[node] = new Node(a.val, Math.min(a.idx, b.idx));
            }else {
                return tree[node] = new Node(a.val, a.idx);
            }
        }

        public Node update(int node, int start, int end, int idx, int val) {

            if (idx < start || end < idx)
                return tree[node];

            if (start == end)
                return tree[node] = new Node(val, tree[node].idx);
            Node a = update(node * 2, start, (start + end) / 2, idx, val);
            Node b = update(node * 2 + 1, (start + end) / 2 + 1, end, idx, val);
            if(a.val>b.val){
                return tree[node] = new Node(b.val, b.idx);
            }else if(a.val==b.val){
                return tree[node] = new Node(a.val, Math.min(a.idx, b.idx));
            }else {
                return tree[node] = new Node(a.val, a.idx);
            }
        }

        public Node sum(int node, int start, int end, int left, int right) {

            if (left > end || right < start) {
                return new Node(Integer.MAX_VALUE,Integer.MAX_VALUE);
            }

            if (left <= start && end <= right) {
                return tree[node];
            }
            Node a = sum(node * 2, start, (start + end) / 2, left, right);
            Node b = sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            if(a.val>b.val){
                return new Node(b.val, b.idx);
            }else if(a.val==b.val){
                return new Node(a.val, Math.min(a.idx, b.idx));
            }else {
                return new Node(a.val, a.idx);
            }

        }
    }

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        SegmentTree sTree = new SegmentTree(n);
        sTree.init(arr, 1, 1, n);

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (order == 1) {
                arr[a] = b;
                sTree.update(1, 1, n, a, b);
            } else {
                bw.write(sTree.sum(1, 1, n, a, b).idx + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
