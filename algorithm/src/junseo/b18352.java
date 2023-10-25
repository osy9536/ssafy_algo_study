package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N,M,K,X;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    List<ArrayList<Integer>> list;
    list = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      ArrayList<Integer> temp = new ArrayList<>();
      list.add(temp);
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.get(a).add(b);
    }

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int [] vis = new int[N+1];
    for (int i = 0; i <= N; i++) {
        vis[i] = -1;
    }
    queue.add(X);
    vis[X] = 0;
    while(!queue.isEmpty()){
      int cur = queue.poll();

      for (int i = 0; i < list.get(cur).size(); i++) {
        if(vis[list.get(cur).get(i)] == -1){
          queue.add(list.get(cur).get(i));
          vis[list.get(cur).get(i)] = vis[cur]+1;
        }
      }
    }
    boolean flag = false;
    for (int i = 1; i <= N; i++) {
      if(vis[i] == K) {
        System.out.println(i);
        flag = true;
      }
    }
    if (!flag) System.out.println(-1);
  }
}


