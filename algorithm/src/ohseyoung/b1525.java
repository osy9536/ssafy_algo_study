package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 퍼즐
// gold 2
public class b1525 {

    static Map<String, Integer> map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        StringBuilder init = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int a = Integer.parseInt(st.nextToken());
                init.append(a);
            }
        }

        map.put(String.valueOf(init), 0);
        System.out.println(BFS(String.valueOf(init)));
    }

    private static int BFS(String init) {
        Queue<String> q = new LinkedList<>();

        q.add(init);
        while (!q.isEmpty()) {
            String cur = q.poll();
            int move = map.get(cur);
            int zero = cur.indexOf('0');
            int x = zero / 3;
            int y = zero % 3;

            if (cur.equals("123456780")) {
                return move;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0||ny<0||nx>2||ny>2) continue;

                int pos = nx * 3 + ny;
                char c = cur.charAt(pos);
                String next = cur.replace(c, 'c');
                next=next.replace('0', c);
                next = next.replace('c', '0');

                if (!map.containsKey(next)) {
                    q.add(next);
                    map.put(next, move + 1);
                }
            }
        }
        return -1;
    }
}
