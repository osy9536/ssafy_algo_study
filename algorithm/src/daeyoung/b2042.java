package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 2042
 * 구간 합 구하기
 * 골드 1
 * https://www.acmicpc.net/problem/2042
 */
public class b2042 {

    /*
    // 세그먼트 트리 안사용 하고 푼 풀이
    static long[] ary;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //numbers count
        int m = Integer.parseInt(st.nextToken()); //numbers change count
        int k = Integer.parseInt(st.nextToken()); //prefix sum count

        ary = new long[n + 1];

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            ary[i] = ary[i - 1] + Long.parseLong(st.nextToken());
        }

        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                long cur = ary[b] - ary[b -1];
                for (int j = b; j < n + 1; j++) {
                    ary[j] += c - cur;
                }

            } else if(a == 2) {
                long answer = ary[(int) c] - ary[b - 1];
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);

    }*/

    static long[] ary;
    static long[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //numbers count
        int m = Integer.parseInt(st.nextToken()); //numbers change count
        int k = Integer.parseInt(st.nextToken()); //prefix sum count

        ary = new long[n + 1];
        tree = new long[n * 4];

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            ary[i] = Long.parseLong(st.nextToken());
        }

        init(1, n, 1);

        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                long dif = c - ary[b];
                ary[b] = c; //기존에 있는 값도 바꿔줘야 한다. 아니면 다음번에 똑같은 인덱스의  dif값 구할 때 문제가 된다.
                update(1, n, b, dif, 1);
            } else if(a == 2) {
                long answer = sum(1, n, b, (int) c, 1);
                sb.append(answer).append("\n");
            }

        }

        System.out.println(sb);

        br.close();
    }

    static long init(int start, int end, int node) {
        if(start == end) return tree[node] = ary[start];

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) +
                init(mid + 1, end, node * 2 + 1);
    }

    static long sum(int start, int end, int left, int right, int node) {
        if(right < start || left > end) return 0;

        if(left <= start && right >= end) return tree[node];

        int mid = (start + end) / 2;

        return sum(start, mid, left, right, node * 2) +
                sum(mid + 1, end, left, right, node * 2 + 1);
    }

    static void update(int start, int end, int index, long dif, int node) {
        if(index < start || index > end) return ;

        tree[node] += dif;

        if(start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, index, dif, node * 2);
        update(mid + 1, end, index, dif, node * 2 + 1);
    }
}
