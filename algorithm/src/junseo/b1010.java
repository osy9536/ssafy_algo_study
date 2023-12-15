package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
동쪽의 사이트 개수에서
서쪽에 있는 사이트의 개수 만큼 고르면 됨
 이 때 순서를 고려하지 않아야 함
 (오른쪽에서 고른 맨 위 사이트와
 왼쪽에서 고른 맨 위 사이트가 매칭되야함.
 따라서 이 경우 하나만 고려함)
 -> 조합
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuilder  sb = new StringBuilder();
    int T;
    T = Integer.parseInt(br.readLine());

    int[][] D = new int[30][30];
    for (int i = 1; i < 30; i++) {
      D[i][0] = 1;
      D[i][i] = 1;
      D[i][1] = i;
    }

    for (int i = 3; i < 30; i++) {
      for (int j = 2; j < i; j++) {
        D[i][j] = D[i-1][j-1] + D[i-1][j];
      }
    }

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      int N,M;
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      sb.append(D[M][N]).append("\n");
    }
    System.out.println(sb);
  }
}


