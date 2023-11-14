package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 선 긋기
// gold 5
public class b2170 {

    static class Pair implements Comparable<Pair> {
        int s, e;

        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.s < o.s) return -1;
            else if (this.s == o.s && this.e < o.e) return -1;
            return 1;
        }
    }

    static Pair[] pairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            pairs[i] = new Pair(a, b);
        }

        Arrays.sort(pairs);

        Pair cur = pairs[0];
        int start = cur.s;
        int end = cur.e;
        int dis = 0;
        for (int i = 1; i < n; i++) {
            Pair next = pairs[i];
            if (next.s < end) {
                end = Math.max(end, next.e);
            } else {
                dis += end - start;
                start = next.s;
                end = next.e;
            }
        }
        dis += end - start;
        System.out.println(dis);
    }
}
