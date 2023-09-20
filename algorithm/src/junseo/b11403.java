package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class b11403 {
    static int N;
    static int[][] arr;
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        res = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            bfs(i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        queue.offer(i);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int j = 0; j <N; j++) {
                if(!visited[j] && arr[cur][j] == 1) {
                    queue.add(j);
                    res[i][j] =1;
                    visited[j] = true;
                }
            }
        }

    }
}


