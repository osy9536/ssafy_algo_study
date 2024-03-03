package ohseyoung.a0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

// 네트워크 연결
// platinum 5
public class b3780 {

    static int[] parent, dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            parent = new int[n + 1];
            dis = new int[n + 1];

            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }

            String line;
            while (!(Objects.equals(line = br.readLine(), "O"))) {
                st = new StringTokenizer(line);

                if (st.nextToken().equals("E")) {
                    int a = Integer.parseInt(st.nextToken());

                    int ans = find(a);
                    sb.append(dis[a]).append("\n");
                }else{
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    parent[a] = b;
                    dis[a] = Math.abs(a - b) % 1000;
                }
            }
        }
        System.out.println(sb);
    }

    private static int find(int a) {

        if (a == parent[a]) {
            return a;
        }

        int next = find(parent[a]);
        dis[a] += dis[parent[a]];

        return parent[a] = next;
    }
}
