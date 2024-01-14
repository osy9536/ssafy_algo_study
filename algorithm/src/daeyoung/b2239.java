package algorithm.src.daeyoung;

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 2239
 * 스도쿠
 * 골드 5
 * https://www.acmicpc.net/problem/2239
 */
public class b2239 {

    private static int[][] sudoku;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];
        for(int i = 0; i < 9; i++) {
            char[] ary = br.readLine().toCharArray();
            for(int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(ary[j]+"");
            }
        }

        dfs(0, 0);

    }

    public static void dfs(int r, int c) {
        if(r == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(sudoku[r][c] != 0) {
            if(c < 8)
                dfs(r, c + 1);
            else
                dfs(r + 1, 0);

            return;
        }

        boolean[] visited = new boolean[9];
        //가로
        checkRow(r, visited);

        //세로
        checkCol(c, visited);

        //3*3
        checkThree(r, c, visited);

        for (int i = 0; i < 9; i++) {
            if(visited[i])
                continue;
            visited[i] = true;
            sudoku[r][c] = i + 1;
            if(c < 8) {
                dfs(r, c + 1);
            } else {
                dfs(r + 1, 0);
            }
            sudoku[r][c] = 0;
            visited[i] = false;

        }


    }

    public static void checkRow(int r, boolean[] visited) {
        for(int j = 0; j < 9; j++) {
            int value = sudoku[r][j] - 1;
            if(value != -1)
                visited[value] = true;
        }
    }

    public static void checkCol(int c, boolean[] visited) {
        for(int i = 0; i < 9; i++) {
            int value = sudoku[i][c] - 1;
            if(value != -1)
                visited[value] = true;
        }
    }

    public static void checkThree(int r, int c, boolean[] visited) {
        int sr = r / 3 * 3;
        int sc = c / 3 * 3;

        for(int i = sr; i < sr + 3; i++) {
            for(int j = sc; j < sc + 3; j++) {
                if(sudoku[i][j] != 0)
                    visited[sudoku[i][j] - 1] = true;
            }
        }
    }

}
