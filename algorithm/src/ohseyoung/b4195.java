package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 친구 네트워크
// gold 2
public class b4195 {

    static int[] parent, level;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {

            Map<String, Integer> map = new HashMap<>();
            int idx = 0;

            int F = Integer.parseInt(br.readLine());
            parent = new int[F * 2];
            level = new int[F * 2];

            for (int j = 0; j < F * 2; j++) {
                parent[j] = j;
                level[j] = 1;
            }

            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    map.put(a, idx++);
                }

                if (!map.containsKey(b)) {
                    map.put(b, idx++);
                }

                sb.append(union(map.get(a), map.get(b))).append("\n");
            }
        }
        System.out.print(sb);
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static int union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
            level[pa] += level[pb];
        }

        return level[pa];
    }
}
