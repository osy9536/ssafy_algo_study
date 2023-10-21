package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    mData[] A = new mData[N];
    for (int i = 0; i < N; i++) {
      A[i] = new mData(i,Integer.parseInt(br.readLine()));
    }
    Arrays.sort(A,(o1, o2) -> o1.value - o2.value);
    int max = 0;
    for (int i = 0; i < N; i++) {
      max = Math.max(max,A[i].index - i);
    }
    System.out.println(max+1);

  }

  public static class mData {
    public int index;
    public int value;
    public mData(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
}


