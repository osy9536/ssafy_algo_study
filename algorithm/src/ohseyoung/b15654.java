package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과M(5)
// silver 3
public class b15654 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        perm(0, new int[M], new boolean[N]);
        System.out.print(sb);
    }
    static void perm(int cnt, int[] selected, boolean[] visited) {
        if(cnt == M) {
            for(int i=0;i<cnt;i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                selected[cnt] = arr[i];
                visited[i] = true;
                perm(cnt+1, selected, visited);
                visited[i] = false;
            }
        }
    }

}
