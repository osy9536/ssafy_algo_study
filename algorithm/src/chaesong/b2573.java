import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N, M, bingCnt;
    static int arr[][]; static boolean visit[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        //빙산만들기
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 1; 
        while(true) {            
            bingCnt = 0;
            melt();
            visit = new boolean[N][M];
            for(int i = 1; i < N; i++) {
                for(int j = 0; j < M-1; j++) {
                    if(arr[i][j] != 0 && !visit[i][j]) {
                        bfs(i, j);
                        bingCnt++;
                    }
                }
            }
            if(bingCnt == 0) {
            	cnt = 0; break;
            }
            else if(bingCnt >= 2) break;
            else cnt++;
        }
        System.out.println(cnt);
    }
    static void melt() {
        int next[][] = new int[N][M];
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M-1; j++){
                if(arr[i][j] != 0) {
                    int cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dir[k][0];
                        int ny = j + dir[k][1];
                        if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                            if (arr[nx][ny] == 0) cnt++;
                        }
                    }
                    next[i][j] = arr[i][j] <= cnt? 0 : arr[i][j] - cnt;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = next[i][j];
            }
        }
    }
    static void bfs(int i, int j) {
    	Queue<int[]> q = new LinkedList<>();
    	visit[i][j] = true;
        int now[] = {i, j};
        q.add(now);
        while(!q.isEmpty()) {
        	int temp[] = q.poll();
        	for(int k = 0; k < 4; k++) {
        		int nx = temp[0] + dir[k][0];
        		int ny = temp[1] + dir[k][1];
        		if(0 <= nx && nx < N && 0 <= ny && ny < M) {
        			if(arr[nx][ny] != 0 && !visit[nx][ny]) {
        				visit[nx][ny] = true;
        				int next[] = {nx, ny};
        				q.add(next);
        			}
        		}
        	}
        }
    }
}
