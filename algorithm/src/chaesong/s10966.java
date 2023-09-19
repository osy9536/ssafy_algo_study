import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Mul {
    static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int visit[][];
    static int N, M, hap;
    static char arr[][];
    static Queue<Position> q;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	q = new LinkedList<>();
            hap = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new char[N][M];
            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                for(int j = 0; j < M; j++) {
                    arr[i][j] = line.charAt(j);
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == 'W') q.add(new Position(i, j));
                }
            }
            visit = new int[N][M];
            bfs();
            System.out.println("#"+t+" "+hap);
        }
    }
    static class Position{
        int x, y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void bfs() {
        while(!q.isEmpty()) {
            Position temp = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = temp.x + dir[k][0];
                int ny = temp.y + dir[k][1];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && visit[nx][ny] == 0 && arr[nx][ny] == 'L') {
                    visit[nx][ny] = visit[temp.x][temp.y] + 1;
                    hap += visit[nx][ny];
                    q.add(new Position(nx, ny));
                }
            }
        }
    }
}
