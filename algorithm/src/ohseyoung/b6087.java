package algorithm.src.ohseyoung;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 레이저 통신
// gold 3
public class b6087 {
    public static class Node {
        public int y;
        public int x;
        public int cnt;
        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> q = new LinkedList<>();

        int ans = 0;
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int ay = 0;
        int ax = 0;

        for (int i = 0; i < h; ++i) {
            String str = br.readLine();
            for (int j = 0; j < w; ++j) {
                map[i][j] = (str.charAt(j) == '.' ? -1 : (str.charAt(j) == '*' ? -2 : -3));
                if(map[i][j] == -3) {
                    ay = i;
                    ax = j;
                }
            }
        }

        map[ay][ax] = 0;
        q.add(new Node(ay, ax, 0));
        while(!q.isEmpty()) {
            Node p = q.poll();
            for(int i=0; i<4; ++i) {
                int nextY = p.y;
                int nextX = p.x;
                while(true) {
                    nextY += dy[i];
                    nextX += dx[i];
                    if(nextY < 0 || nextX < 0 || nextY >= h || nextX >= w) {
                        break;
                    }
                    if(map[nextY][nextX] == -3) {
                        ans = p.cnt;
                        while(!q.isEmpty()) {
                            q.poll();
                        }
                        break;
                    } else if(map[nextY][nextX] == -2) {
                        break;
                    } else if(map[nextY][nextX] == -1) {
                        map[nextY][nextX] = p.cnt;
                        q.add(new Node(nextY, nextX, p.cnt + 1));
                    } else if(map[nextY][nextX] >= 0 && map[nextY][nextX] != p.cnt) {
                        break;
                    }
                }
            }
        }

        bw.write(ans + "");
        bw.close();
    }

}
