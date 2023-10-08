package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.StringTokenizer;

public class b1926 {
  static int[][] map;
  static int n,m;
  static boolean [][] vis;
  static int[] dx = {-1,1,0,0};//상하좌우
  static int[] dy = {0,0,-1,1};
  static int res;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st  = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    vis = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int cnt = 0;
    res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(!vis[i][j] && map[i][j] == 1 ){
          bfs(i,j);
          cnt++;
        }
      }
    }
    System.out.println(cnt);
    System.out.println(res);
  }

  private static void bfs(int i, int j) {
    ArrayDeque<int []> queue = new ArrayDeque<>();
    queue.add(new int[] {i,j});
    vis[i][j] = true;
    int cnt = 0;
    while(!queue.isEmpty()){
      int[] cur = queue.poll();
      cnt++;
      int x = cur[0];
      int y = cur[1];
      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];
        if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] != 1 || vis[nx][ny]) continue;
        vis[nx][ny] = true;
        queue.add(new int[] {nx,ny});
      }
    }
    res = Math.max(res,cnt);
  }
}

