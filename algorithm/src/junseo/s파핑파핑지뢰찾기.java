import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class s파핑파핑지뢰찾기 {

    static int[][] map;
    static int N;
    static int ans;
    static int [] dr = {-1,-1,-1,0,0,1,1,1};
    static int [] dc = {-1,0,1,-1,1,-1,0,1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T ; t++) {
           N = Integer.parseInt(br.readLine());
           map = new int[N][N];
           ans = 0;
            for (int i = 0; i < N; i++) {
                char[] arr = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    if(arr[j] == '.') map[i][j] = -1;
                    else map[i][j] = -2;
                }
            }
            solve();
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != -1) continue;
                if(isZero(i,j)){
                    click(i,j);
                    ans++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == -1) ans++;
            }
        }
    }

    private static void click(int r, int c){

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r,c});
        map[r][c] = 0;
        while(!queue.isEmpty()){
            int [] cur = queue.poll();
            map[cur[0]][cur[1]] = 0;
            for (int i = 0; i < 8; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != -1) continue;
                if(isZero(nr,nc)) queue.add(new int[] {nr,nc});
                map[nr][nc] = 0;
            }
        }
    }

    private static boolean isZero(int r, int c) {

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr<0 || nc<0 || nr>=N | nc >= N){
                continue;
            }
            if(map[nr][nc] == -2) return false;
        }
        return true;
    }

}

