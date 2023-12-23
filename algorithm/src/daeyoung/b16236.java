package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/**
* 백준 16236
* 아기 상어
* 골드 3
* https://www.acmicpc.net/problem/16236
*/
public class b16236 {

    static class Fish implements Comparable<Fish> {

        int x;
        int y;
        int size; //상어 사이즈
        int count; //잡아먹은 물고기 수
        int s; //걸린 시간

        public Fish(int x, int y, int size, int count, int s) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.count = count;
            this.s = s;
        }

        @Override
        public int compareTo(Fish o) {

            if(this.s == o.s) {
                if(this.x == o.x)
                    return Integer.compare(this.y, o.y);
                return Integer.compare(this.x, o.x);
            }

            return Integer.compare(this.s, o.s);
        }
    }

    static int n;
    static int[][] ocean;
    static int[] dy = {0, -1,  0, 1};
    static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        ocean = new int[n][n];
        int curI = -1;
        int curJ = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
                if(ocean[i][j] == 9) {
                    curI = i;
                    curJ = j;
                    ocean[i][j] = 0;
                }
            }
        }

        System.out.println(bfs(curI, curJ));
    }

    public static int bfs(int curI, int curJ) {

        Queue<Fish> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];

        int nx = curI;
        int ny = curJ;
        int tempSize = 2;
        int tempCount = 0;
        int tempS = 0;
        int answer = 0;

        Fish f = new Fish(nx, ny, tempSize, tempCount, tempS);
        q.add(f);
        visited[nx][ny] = true;

        while(!q.isEmpty()) {
            f = q.poll();

            tempCount = f.count;
            tempSize = f.size;
            tempS = f.s;

            if(ocean[f.x][f.y] != 0 && tempSize > ocean[f.x][f.y]) {
                visited = new boolean[n][n];
                q.clear();
                ocean[f.x][f.y] = 0;
                answer = tempS;

                if(f.count + 1 == f.size) {
                    tempCount = 0;
                    tempSize++;
                } else {
                    tempCount++;
                }

                visited[f.x][f.y] = true;
            }

            for(int i = 0; i < 4; i++) {
                nx = f.x + dx[i];
                ny = f.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || ocean[nx][ny] > tempSize)
                    continue;

                q.add(new Fish(nx, ny, tempSize, tempCount, tempS + 1));
                visited[nx][ny] = true;
            }
        }

        return answer;
    }

}
