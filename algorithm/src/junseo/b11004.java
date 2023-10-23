package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11004_K번째수_퀵정렬 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N,K;
    int [] A;
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    A = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    quickSort(A,0,N-1,K-1);
    System.out.println(A[K-1]);
  }

  private static void quickSort(int[] A, int S, int E, int K) {
    if(S<E){
      int pivot = partition(A,S,E);
      if(pivot == K) return;
      else if(pivot<K) quickSort(A,pivot+1,E,K);
      else quickSort(A,S,pivot-1,K);
    }
  }

  private static int partition(int[] A, int S, int E) {
    if(S+1 == E){
      if(A[S] > A[E]) swap(A,S,E);
      return E;
    }
    int M = (S+E)/2;
    swap(A,S,M);
    int pivot = A[S];
    int i = S+1,j=E;
    while(i<=j){
      while (j>=S+1 && pivot<A[j]){
        j--;
      }
      while (i<=E&&pivot>A[i]){
        i++;
      }
      if(i<=j){
        swap(A,i++,j--);
      }
    }
    A[S]=A[j];
    A[j] = pivot;
    return j;


  }

  private static void swap(int[] A, int S, int E) {
    int temp = A[S];
    A[S] = A[E];
    A[E] = temp;
  }
}


