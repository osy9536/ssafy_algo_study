
import java.io.*;
import java.util.*;

// 맥주 마시면서 걸어가기
// gold 5
public class b9205 {

    static int n, homeX, homeY, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            List<int[]> list = new ArrayList<>(); // 편의점 위치
            // 초기화 시작
            n = Integer.parseInt(br.readLine()); // 편의점 개수
            st = new StringTokenizer(br.readLine());
            homeX = Integer.parseInt(st.nextToken()); // 집 위치
            homeY = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new int[]{x, y});
            }
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken()); // 종점 위치
            endY = Integer.parseInt(st.nextToken());
            // 초기화 끝

            bw.write(bfs(list) ? "happy\n" : "sad\n");
        }

        bw.flush();
        bw.close();
    }

    static boolean bfs(List<int[]> list) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new int[]{homeX, homeY});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            if (Math.abs(cx - endX) + Math.abs(cy - endY) <= 1000) {
                return true;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int nx = list.get(i)[0];
                    int ny = list.get(i)[1];
                    int dis = Math.abs(cx - nx) + Math.abs(cy - ny);
                    if (dis <= 1000) {
                        visited[i] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }
}
