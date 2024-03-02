package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1326 {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(BFS(a, b));
    }

    private static int BFS(int a, int b) {
        visit = new int[N + 1];
        Arrays.fill(visit, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { a, 0 });
        visit[a] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == b) {
                return now[1];
            }

            for (int i = now[0]; i > 0; i -= arr[now[0]]) {
                if (now[1] + 1 < visit[i]) {
                    visit[i] = now[1] + 1;
                    queue.add(new int[] { i, now[1] + 1 });
                }
            }
            for (int i = now[0]; i <= N; i += arr[now[0]]) {
                if (now[1] + 1 < visit[i]) {
                    visit[i] = now[1] + 1;
                    queue.add(new int[] { i, now[1] + 1 });
                }
            }
        }

        return -1;
    }
}