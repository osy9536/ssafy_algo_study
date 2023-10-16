package algorithm.src.ohseyoung;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

import static java.lang.Math.abs;

// 행성 터널
// platinum 5
public class b2887 {

    static List<int[]> p;
    static List<Point>[] list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            p.add(new int[]{i, x, y, z});
        }

        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= 3; i++) {
            int start = i;
            p.sort(Comparator.comparingInt(o -> o[start]));
            for (int j = 1; j < N; j++) {
                int[] p1 = p.get(j - 1);
                int[] p2 = p.get(j);
                int dis = abs(p1[i] - p2[i]);

                list[p1[0]].add(new Point(p2[0], dis));
                list[p2[0]].add(new Point(p1[0], dis));
            }
        }

        prim(0);
    }

    private static void prim(int start) {
        Queue<Point> pq = new PriorityQueue<>(((o1, o2) -> (o1.y-o2.y)));
        boolean[] checked = new boolean[N];
        pq.add(new Point(start, 0));

        long sum = 0;
        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if (checked[cur.x]) continue;

            checked[cur.x] = true;
            sum += cur.y;

            for (Point p : list[cur.x]) {
                if (!checked[p.x]) {
                    pq.add(p);
                }
            }
        }
        System.out.println(sum);
    }
}
