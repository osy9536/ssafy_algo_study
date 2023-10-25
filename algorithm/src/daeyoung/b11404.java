package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
 * 백준 11404
 * 플로이드
 * 골드 4
 * https://www.acmicpc.net/problem/11404
 */
public class b11404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시 수
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 버스 수(간선 수)

        int max = 987654321;
        int[][] distance = new int[n + 1][n + 1];

        for(int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i == j)
                    continue;
                distance[i][j] = max;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            distance[c1][c2] = Math.min(cost, distance[c1][c2]);
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                if(i == k)
                    continue;
                for (int j = 1; j < n + 1; j++) {
                    if(j == i || j == k)
                        continue;
                    if(distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(distance[i][j] == max) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

    }
}
