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
    A  = Long.parseLong(st.nextToken());
    B  = Long.parseLong(st.nextToken());
    boolean [] arr;
    int aLength = (int) Math.sqrt(B);
    arr = new boolean[aLength+1];
    int length = (int) Math.sqrt(aLength);
    for (int i = 2; i <= length; i++) {
      if(!arr[i]){
        for (int j = i+i; j <= aLength ; j=j+i) {
            if(!arr[j]){
              arr[j] = true;
            }
        }
      }
    }

    //-------------------------------------------------------
    int cnt = 0;
    for (int i = 2; i <=aLength; i++) {
      if(!arr[i]){
        long temp = i;
        while((double)i<=(double)B/temp){
          if((double)i>=(double)A/temp) cnt++;
          temp *= i;
        }
      }
    }
    System.out.println(cnt);


  }
}

