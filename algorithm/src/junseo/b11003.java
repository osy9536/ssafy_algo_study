package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    Deque<Node> deque = new ArrayDeque<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int a = Integer.parseInt(st.nextToken());
      Node node  = new Node(i,a);
      if(!deque.isEmpty() && (i - deque.getFirst().index) >= L){ // 현재 입력될 노드의 인덱스 - deque의 맨 앞 node의 인덱스가 L과 같거나 크면
                                                                  // 맨 앞을 remove
        deque.removeFirst();
      }
      while (!deque.isEmpty() && deque.getLast().val > a){
        deque.removeLast();
      }
      deque.addLast(node);
      sb.append(deque.getFirst().val).append(" ");
    }
    System.out.println(sb);
  }

  private static class Node {
    int index;
    int val;

    public Node(int index, int val) {
      this.index = index;
      this.val = val;
    }
  }
}



