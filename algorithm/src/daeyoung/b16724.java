package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/*
 * 백준 16724
 * 피리 부는 사나이
 * 골드 3
 * https://www.acmicpc.net/problem/16724
 */
public class b16724 {

    static int n;
    static int m;

    static char[][] map;

    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();

        int answer = 0;

        visited = new int[n][m];

        int cnt = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                answer += markStep(i, j, cnt++);
            }
        }

        System.out.println(answer);
    }

    public static int markStep(int startX, int startY, int cnt) {
        int nextX = startX;
        int nextY = startY;
        int check = 1;

        while(true) {

            if(visited[nextX][nextY] == cnt) {
                break;
            }

            if(visited[nextX][nextY] != 0) {
                check = 0;
                break;
            }

            visited[nextX][nextY] = cnt;

            if(map[nextX][nextY] == 'U') {
                nextX -= 1;
            } else if (map[nextX][nextY] == 'D') {
                nextX += 1;
            } else if (map[nextX][nextY] == 'L') {
                nextY -= 1;
            } else if (map[nextX][nextY] == 'R') {
                nextY += 1;
            }
        }

        return check;
    }
}
