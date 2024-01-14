package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    int M;
    int[] dol = new int[51];
    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int sum = 0;
    for (int i = 0; i < M; i++) {
      dol[i] = Integer.parseInt(st.nextToken());
      sum +=dol[i];
    }
    int K;
    K = Integer.parseInt(br.readLine());
    double [] ans = new double[51];
    for (int i = 0; i < M; i++) {
      if(dol[i] < K) continue;
      ans[i] = 1.0;
      for (int j = 0; j <K; j++) {
        ans[i] *= (double) (dol[i] - j) / (sum-j);
      }
    }
    double res = 0;
    for (int i = 0; i < M; i++) {
      res += ans[i];
    }
    System.out.println(res);

  }
}

