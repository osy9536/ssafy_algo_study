package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();
    int N;
    N = Integer.parseInt(br.readLine());
    long [] D = new long[N+1]; // 자릿수마다 가능한 경우의 수
    D[0] = 1;
    for (int i = 1; i <= N ; i++) {
      D[i] = D[i-1] * i;
    }
    //System.out.println(Arrays.toString(D));
    st = new StringTokenizer(br.readLine());
    int number = Integer.parseInt(st.nextToken());

    if(number == 1){
      boolean []vis = new boolean[N+1];
      long k;
      k = Long.parseLong(st.nextToken());
      for (int i = 1; i <= N; i++) {
        for (int j = 1,cnt =1; j <=N ; j++) {
          if(vis[j]) continue;
          if(k<=cnt*D[N-i]){
            sb.append(j).append(" ");
            vis[j] = true;
            k -= (cnt-1) * D[N-i];
            break;
          }
          cnt++;
        }
      }
      System.out.println(sb);
    }

    else{
      boolean []vis = new boolean[N+1];
      long k = 1;
      for (int i = 1; i <= N ; i++) {
        int a = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int j = 1; j < a; j++) {
          if(!vis[j]) cnt++;
        }
        k += (cnt *D[N-i]);
        vis[a] = true;
      }
      System.out.println(k);
    }
  }
}


