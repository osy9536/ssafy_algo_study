package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유기농 배추
// silver 2
public class b1012 {
    static int[][] map;
    static boolean[][] visited;
    static int cnt, x, y;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            cnt = 0;
            map = new int[x][y];
            visited = new boolean[x][y];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }
            for(int i = 0 ; i<x; i++){
                for(int j = 0; j<y; j++){
                    if(map[i][j]==0)continue;
                    if(visited[i][j])continue;
                    dfs(i,j);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int x0, int y0) {
        if (!visited[x0][y0]) {
            if(map[x0][y0]==1){
                visited[x0][y0]=true;
                for (int i = 0; i < 4; i++) {
                    int x1 = x0 + dx[i];
                    int y1 = y0 + dy[i];
                    if (x1 >= 0 && y1 >= 0 && x1 < x && y1 < y ) {
                        dfs(x1, y1);
                    }
                }
            }
        }
    }
}

