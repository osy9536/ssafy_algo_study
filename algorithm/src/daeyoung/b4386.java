package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 4386
 * 별자리 만들기
 * 골드 3
 * https://www.acmicpc.net/problem/4386
 */
public class b4386 {

    static int n;
    static double[][] stars;

    static List<List<double[]>> path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        stars = new double[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        path = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            path.add( new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                double d = getDistance(stars[i][0], stars[i][1], stars[j][0], stars[j][1]);

                path.get(i).add(new double[] {d, j});
                path.get(j).add(new double[] {d, i});
            }
        }

        System.out.println(String.format("%.2f", prim()));
    }

    public static double prim() {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((o1, o2) -> {
            return Double.compare(o1[0], o2[0]);
        });
        boolean[] visited = new boolean[n];

        pq.add(new double[] {0, 0});

        double min = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {

            double[] cur = pq.poll();

            if(visited[(int) cur[1]])
                continue;

            visited[(int) cur[1]] = true;
            min += cur[0];

            for(double[] next : path.get((int) cur[1])) {
                if(!visited[(int) next[1]]) {
                    pq.add(new double[] {next[0], next[1]});
                }
            }

            if(++cnt == n) break;
        }

        return min;
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {

        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}

