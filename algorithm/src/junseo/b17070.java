package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17070 {
    static int[] dx = {0,1,1}; //가로,세로,대각선 아래
    static int[] dy = {1,0,1};
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    private static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <N ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ////////////////////////////////////////////////////////
        visited = new boolean[N][N];
        visited[0][0] = true;
        visited[0][1] = true;
        res = 0;
        dfs(0,1,0);
        System.out.println(res);
    }

    private static void dfs(int x, int y, int dir) {
        if(x == N-1 && y == N-1){
            res+=1;
            return;
        }
        for (int i = 0; i <3; i++) {
            if(dir == 0) {
                if (i==1)continue;
            }
            if(dir == 1) {
                if (i==0)continue;
            }
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny >=0 && nx<N&&ny<N&&!visited[nx][ny]&&arr[nx][ny]!=1){
                if(i==2){
                    if(arr[nx][y]!=1 && arr[x][ny] !=1){
                        visited[nx][ny] = true;
                        dfs(nx,ny,i);
                        visited[nx][ny] = false;
                    }
                }else{
                    visited[nx][ny] = true;
                    dfs(nx,ny,i);
                    visited[nx][ny] = false;
                }
            }

        }
    }
}


