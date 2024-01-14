package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11050 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N, K;
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    /*
    DP이용
     */
    int [][] D = new int[N+1][N+1];

    for (int i = 0; i <= N; i++) {
      D[i][1] = i;
      D[i][0] = 1;
      D[i][i] = 1;
    }
    for (int i = 2; i <= N ; i++) {
      for (int j = 1; j < i ; j++) {
        D[i][j] = D[i-1][j] + D[i-1][j-1];
      }
    }
    System.out.println(D[N][K]);

  }
}



