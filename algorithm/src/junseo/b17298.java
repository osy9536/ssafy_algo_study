package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayDeque<Node> stack = new ArrayDeque<>();
    StringBuilder sb=  new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int [] A = new int[N];
    int [] ans = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    stack.push(new Node(0,A[0]));
    for (int i = 1; i < N; i++) {

      while(!stack.isEmpty() && stack.peekFirst().value<A[i]){
        ans[stack.pop().index] = A[i];
      }
      stack.push(new Node(i,A[i]));
    }
    while(!stack.isEmpty()){
      ans[stack.pop().index] = -1;
    }
    for (int i = 0; i < N; i++) {
      sb.append(ans[i]).append(" ");
    }
    System.out.println(sb);
  }

  private static class Node {
    public int index;
    public int value;

    public Node(int index,int value) {
      this.index = index;
      this.value = value;

    }
  }
}


