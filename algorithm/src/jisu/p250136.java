package algorithm.src.jisu;

import java.util.*;

class p250136 {
    static int n, m;
    static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
    public boolean isOut(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= m;
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        
        int[][] chunk = new int[n][m];
        Map<Integer, Integer> map = new HashMap<>();
        int cIdx = 0;
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] || land[i][j] == 0) continue;
                visit[i][j] = true;
                cIdx++;
                map.put(cIdx, 1);
                chunk[i][j] = cIdx;
                Queue<int[]> que = new ArrayDeque<>();
                que.add(new int[] {i, j});
                
                while(!que.isEmpty()) {
                    int[] now = que.poll();
                    for (int k = 0; k < 4; k++) {
                        int y = now[0] + dr[0][k];
                        int x = now[1] + dr[1][k];
                        if (isOut(y,x) || visit[y][x] || land[y][x] == 0) continue;
                        que.add(new int[] {y,x});
                        visit[y][x] = true;
                        chunk[y][x] = cIdx;
                        map.put(cIdx, map.get(cIdx) + 1);
                    }
                }
            }
        }
        
        int maxi = -1;
        
        for (int j = 0; j < m; j++) {
            Set<Integer> set = new HashSet<>();
            int summ = 0;
            for (int i = 0; i < n; i++) {
                if (chunk[i][j] != 0) set.add(chunk[i][j]);
            }
            for (int k : set) {
                summ += map.get(k);
            }
            if (maxi < summ) maxi = summ;
        }
        
        
        return maxi;
    }
}
