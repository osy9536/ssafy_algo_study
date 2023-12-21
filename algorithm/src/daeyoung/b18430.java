package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 18430
 * 무기 공학
 * 골드 4
 * https://www.acmicpc.net/problem/18430
 */
public class b18430 {

    static int n; //세로
    static int m; //가로
    static int[][] tree; //나무 강도
    static boolean[][] checked; //쓴 나무
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로

        tree = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        checked =  new boolean[n][m];
        dfs(0, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int midI, int midJ, int temp) {

        if(midI >= n) {
            answer = Math.max(answer, temp);
            return;
        }

        if(midJ >= m) {
            dfs(midI + 1, 0, temp);
            return;
        }

        if(midJ - 1 >= 0 && midI + 1 < n && midI >= 0 && midJ < m &&
            !checked[midI][midJ] && !checked[midI + 1][midJ] && !checked[midI][midJ - 1]) {
            checked[midI][midJ] = true;
            checked[midI + 1][midJ] = true;
            checked[midI][midJ - 1] = true;

            dfs(midI, midJ + 1,
                    temp + sum(midI, midJ - 1, midI, midJ, midI + 1, midJ));

            checked[midI][midJ] = false;
            checked[midI + 1][midJ] = false;
            checked[midI][midJ - 1] = false;
        }

        if(midJ - 1 >= 0 && midI - 1 >= 0 && midI < n && midJ < m &&
                !checked[midI][midJ] && !checked[midI - 1][midJ] && !checked[midI][midJ - 1]) {
            checked[midI][midJ] = true;
            checked[midI - 1][midJ] = true;
            checked[midI][midJ - 1] = true;

            dfs(midI, midJ + 1,
                    temp + sum(midI, midJ - 1, midI, midJ, midI - 1, midJ));

            checked[midI][midJ] = false;
            checked[midI - 1][midJ] = false;
            checked[midI][midJ - 1] = false;
        }

        if(midJ + 1 < m && midI - 1 >= 0 && midI < n && midJ >= 0 &&
                !checked[midI][midJ] && !checked[midI - 1][midJ] && !checked[midI][midJ + 1]) {
            checked[midI][midJ] = true;
            checked[midI - 1][midJ] = true;
            checked[midI][midJ + 1] = true;

            dfs(midI, midJ + 1,
                    temp + sum(midI, midJ + 1, midI, midJ, midI - 1, midJ));

            checked[midI][midJ] = false;
            checked[midI - 1][midJ] = false;
            checked[midI][midJ + 1] = false;
        }

        if(midJ + 1 < m && midI + 1 < n && midI >= 0 && midJ >= 0 &&
                !checked[midI][midJ] && !checked[midI + 1][midJ] && !checked[midI][midJ + 1]) {
            checked[midI][midJ] = true;
            checked[midI + 1][midJ] = true;
            checked[midI][midJ + 1] = true;

            dfs(midI, midJ + 1,
                    temp + sum(midI, midJ + 1, midI, midJ, midI + 1, midJ));

            checked[midI][midJ] = false;
            checked[midI + 1][midJ] = false;
            checked[midI][midJ + 1] = false;
        }

        dfs(midI, midJ + 1, temp);

    }

    public static int sum(int i1, int j1, int i2, int j2, int i3, int j3) {
        return tree[i1][j1] + 2 * tree[i2][j2] + tree[i3][j3];
    }
}
