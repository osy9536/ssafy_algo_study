package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [] D = new int[N+1];

    D[1] = 0;
    for (int i = 2; i <= N; i++) {
      D[i] = D[i-1] + 1;
      if(i%2==0) D[i] = Math.min(D[i/2]+1,D[i]);
      if(i%3==0) D[i] = Math.min(D[i/3]+1,D[i]);
    }
    System.out.println(D[N]);
  }
}

