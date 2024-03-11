package algorithm.src.daeyoung;

import java.util.*;

/**
 * 프로그래머스 - 게임 맵 최단거리
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class p1844 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int min = Integer.MAX_VALUE;
    static int n;
    static int m;

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        n = maps.length;
        m = maps[0].length;

        bfs(maps);

        if(min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }

    public static void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, 0, 1});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == n - 1 && cur[1] == m - 1) {
                min = Math.min(min, cur[2]);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                if(nextX >= n || nextX < 0 || nextY >= m || nextY < 0)
                    continue;

                if(maps[nextX][nextY] == 0)
                    continue;

                maps[nextX][nextY] = 0;
                q.add(new int[]{nextX, nextY, cur[2] + 1});
            }

        }
    }
}
