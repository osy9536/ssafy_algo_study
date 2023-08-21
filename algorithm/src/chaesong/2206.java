import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2206 {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int N; static int M;
    static int arr[][]; static int dist[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        int ans = bfs(0, 0);
        if (N-1 == 0 && M-1 == 0) {
        	ans = 1;
        }
        System.out.println(ans);
    }
    static int bfs(int stx, int sty) {
        StringBuilder sb = new StringBuilder();
        Queue<int[]> q = new LinkedList<>();
        dist = new int[N][M][2]; 
        int start[] = {stx, sty, 0};
        q.add(start);
        dist[stx][sty][0] = 1;
        while(!q.isEmpty()) {
        	//현재위치
            int temp[] = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    //벽을 만났다면
                    if(arr[nx][ny] == 1) {
                        if(temp[2] == 0 && dist[nx][ny][1] == 0) {
                            int now[] = {nx, ny, 1};
                            q.add(now);
                            dist[nx][ny][1] = dist[temp[0]][temp[1]][temp[2]] + 1;
                        }
                    }
                    //벽이 아니라면
                    else {
                    	if(dist[nx][ny][temp[2]] == 0) {
                    		 int now[] = {nx, ny, temp[2]};
                             q.add(now);
                             dist[nx][ny][temp[2]] = dist[temp[0]][temp[1]][temp[2]] + 1;
                    	}
                    }
                    //도착한다면
                    if(nx == N-1 && ny == M-1) {
                    	return dist[nx][ny][temp[2]];
                    }
                }
            }
        }
        return -1;
    }
}
