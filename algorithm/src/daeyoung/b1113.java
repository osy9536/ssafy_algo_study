import java.io.*;
import java.util.*;

/**
 * 백준 1113
 * 수영장 만들기
 * 골드 1
 * https://www.acmicpc.net/problem/1113
 */
public class b1113 {

    static int n, m;
    static int[][] pool;
    static boolean[][] visited;
    static boolean check;
    static int water = 0;
    static int temp = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //row
        m = Integer.parseInt(st.nextToken()); //column

        pool = new int[n][m];

        int max = 0;
        for(int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                pool[i][j] = temp[j] - '0';
                max = Math.max(max, pool[i][j]);
            }
        }

        for(int h = 2; h <= max; h++) {
            visited = new boolean[n][m];
            for(int i = 1; i < n - 1; i++) {
                for(int j = 1; j < m - 1; j++) {
                	check = true;
                	temp = 0;
                	if(pool[i][j] < h && !visited[i][j]) {
                		dfs(i, j ,h);
                		
                		if(check) {
//                			System.out.println(h + " : " + i + " " + j + ", " + temp);
                			water += temp;
                		}
                			
                	}
                }
            }
        }

        System.out.println(water);

    }

    public static void dfs(int curI, int curJ, int height) {
    	visited[curI][curJ] = true;
    	temp += 1;
    	if(curI == n -1 || curJ == m - 1 || curI == 0 || curJ == 0) {
    		if(pool[curI][curJ] < height)
    			check = false;
    	}
    	
        for (int i = 0; i < 4; i++) {
            int ni = curI + dx[i];
            int nj = curJ + dy[i];

            if(ni >= n || ni < 0 || nj >= m || nj < 0 || visited[ni][nj])
                continue;

            if(pool[ni][nj] >= height)
            	continue;

            
            dfs(ni, nj, height);

        }

    }

}
