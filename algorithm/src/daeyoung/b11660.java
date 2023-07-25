package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 백준 11660
 * 구간 합 구하기 5
 * 실버1
 * https://www.acmicpc.net/problem/11660
 */
public class b11660 {
    static class Location {
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Location(int startX, int startY, int endX, int endY) {
            super();
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public int getStartX() {
            return startX;
        }

        public int getStartY() {
            return startY;
        }

        public int getEndX() {
            return endX;
        }

        public int getEndY() {
            return endY;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        Location[] locations = new Location[m];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            locations[i] = new Location(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        for (Location l : locations) {
            int sum = 0;
            for (int i = l.getStartX(); i <= l.getEndX(); i++) {
                sum += dp[i][l.getEndY()] - dp[i][l.getStartY() - 1];
            }
            sb.append(sum).append('\n');
        }

        System.out.print(sb);

    }
}
