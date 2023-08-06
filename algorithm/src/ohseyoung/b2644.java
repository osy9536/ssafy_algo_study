package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 촌수계산
// silver 2
public class b2644 {
    static int end, answer = -1;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> node = new ArrayList<>(); // 양방향 인접리스트
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) node.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 양방향
            node.get(from).add(to);
            node.get(to).add(from);
        }
        // 시작 정점, 촌 수
        dfs(start, 0);
        System.out.println(answer);
    }

    private static void dfs(int point, int cnt) {
        visited[point] = true;
        for (int x : node.get(point)) {
            if (!visited[x]) {
                if (x == end) {
                    answer = cnt + 1;
                    return;
                }
                dfs(x, cnt + 1);
            }
        }
    }
}
