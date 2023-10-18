package algorithm.src.junseo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1546 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int [] A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i <N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    int max = 0;
    int sum = 0;
    for (int i = 0; i <N; i++) {
      sum += A[i];
      max = Math.max(max,A[i]);
    }
    System.out.println((double)sum * 100 / max / N);
  }
}






