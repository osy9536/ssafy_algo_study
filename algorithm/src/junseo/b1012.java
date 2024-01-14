package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b1012 {
  static int N,M,K;
  static int[][] map;
  static boolean[][] vis;
  static int[] dx = {-1,1,0,0}; // 상하좌우
  static int[] dy = {0,0,-1,1};


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuilder sb =  new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <=T ; t++) {
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      map = new int[N][M];
      vis = new boolean[N][M];

      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        map[a][b] = 1;
      }
      int cnt = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (map[i][j] == 1 && !vis[i][j]) {
            bfs(i, j);
            cnt++;
          }
        }
      }
      sb.append(cnt).append("\n");
    }
    System.out.println(sb);
  }
  static void bfs(int i, int j){
    vis[i][j] = true;
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.add(new int [] {i,j});

    while (!queue.isEmpty()){
      int [] cur = queue.poll();
      int x = cur[0];
      int y = cur[1];

      for (int k = 0; k < 4; k++) {
        int nx = x+dx[k];
        int ny = y+dy[k];

        if(nx<0 || nx>=N|| ny<0 || ny>=M || vis[nx][ny]||map[nx][ny] != 1) continue;
        queue.add(new int[] {nx,ny});
        vis[nx][ny] = true;

      }
    }
  }
}

