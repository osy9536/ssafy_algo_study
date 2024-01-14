package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    int N;
    N = Integer.parseInt(br.readLine());

    int [] T = new int[N+1];
    int [] P = new int[N+1];
    int [] D = new int[N+2]; // 해당 일부터 얻을 수 있는 최대 수익 저장

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = N; i > 0 ; i--) {
      if(i + T[i] > N+1) D[i] = D[i+1];
      else{
        D[i] = Math.max(D[i+1],P[i] + D[i+T[i]]);
      }
    }
    System.out.println(D[1]);
  }
}

