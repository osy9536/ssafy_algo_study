package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long A,B;
    A = Long.parseLong(st.nextToken());
    B = Long.parseLong(st.nextToken());
    /*
    a,b,c
    c = a % b ;
    a = b
    b = c
    c = a % b;
    if(c == 0) {
    break;
    ans = b;
    ;
     */
    long C;
    C = A%B;

    while(C!=0){
      A = B;
      B = C;
      C = A%B;
    }

    StringBuilder sb= new StringBuilder();
    for (int i = 0; i < B; i++) {
      sb.append("1");
    }
    System.out.println(sb);

  }
}


