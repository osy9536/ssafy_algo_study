package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N,M,K;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    int[][] D = new int[N+M+1][N+M+1];

    for (int i = 0; i <= N+M; i++) {
      for (int j = 0; j <= i; j++) {
        if(j == 0 || j == i){
          D[i][j] = 1;
        }
        else{
          D[i][j] = D[i-1][j-1] + D[i-1][j];
          if(D[i][j] > 1_000_000_000) {
            D[i][j] = 1_000_000_001;
          }
        }
      }
    }

    if(D[N+M][M]<K){
      System.out.println(-1);
    }
    else{
      StringBuilder sb= new StringBuilder();
      while(!(N==0 && M == 0)){
        if(D[N-1+M][M]>=K){
          sb.append("a");
          N--;
        }
        else{
          sb.append("z");
          K = K - D[N-1+M][M];
          M--;
        }
      }
      System.out.println(sb);
    }
  }
}


