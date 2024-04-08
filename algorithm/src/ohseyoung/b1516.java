package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 게임 개발
// gold 3
public class b1516 {

    static List<Integer>[] lists;
    static int[] times;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        times = new int[n + 1];
        visited = new boolean[n + 1];
        dp = new int[n + 1];
        lists = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // times에는 각 건물들의 짓는 시간
        // lists에는 각 건물들을 짓기 필요 위한 선행 건물
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            times[i] = time;
            int building = 0;
            while ((building = Integer.parseInt(st.nextToken())) != -1) {
                lists[i].add(building);
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            recur(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(dp[i]).append("\n");
        }

        System.out.println(sb);
    }

    static int recur(int num) {
        int cnt = 0;
        for (int i = 0; i < lists[num].size(); i++) {
            int next = lists[num].get(i);
            if (!visited[next]) {
                cnt=Math.max(cnt, recur(next));
                visited[next] = true;
            }else{
                cnt = Math.max(cnt, dp[next]);
            }
        }

        dp[num] = Math.min(dp[num], times[num]+cnt);
        return dp[num];
    }
}
