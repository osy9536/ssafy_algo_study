package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2531 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    int N,d,k,c;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    int [] arr = new int[N];
    int [] cnt = new int[d+1];
    for (int i = 0; i <N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int res = 1;
    for (int i = 0; i < k; i++) {
      if (arr[i] != c && cnt[arr[i]] == 0){
        res++;
      }
      cnt[arr[i]]++;
    }
    int start = 0;
    int end = k-1;
    int max = res;
    while(start<N){
      end++;
      end = end%N;
      if(cnt[arr[end]] == 0 && arr[end] != c) {
        res++;
      }
      cnt[arr[end]]++;
      cnt[arr[start]]--;
      if(cnt[arr[start]] == 0 && arr[start] != c){
        res--;
      }
      start++;
      max = Math.max(res,max);
    }
    System.out.println(max);
  }
}



