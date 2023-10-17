package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b7785 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    int n = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String act = st.nextToken();
      if(act.equals("enter")) set.add(name);
      else set.remove(name);
    }
    int size = set.size();
    String[] arr = new String[size];
    Iterator<String> iterator = set.iterator();

    for (int i = 0; iterator.hasNext(); i++) {
      arr[i] = iterator.next();
    }
    Arrays.sort(arr,Comparator.reverseOrder());

    size = arr.length;

    for (int i = 0; i <size ; i++) {
      System.out.println(arr[i]);
    }

  }
}




