package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b15683 {

    static int N,M;
    static int[][] arr;
    static int cnt;
    static int res;
    static List<int[]> cctv;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cctv = new ArrayList<>();
        cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;
                if(a != 0 && a != 6) {
                    cctv.add(new int[] {i,j});
                    cnt++;
                }
            }
        }
        res = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(res);

    }

    private static void dfs(int depth) {
        if(depth == cnt) {
            check();
            return;
        }
        int [] cur = cctv.get(depth);
        int x = cur[0];
        int y = cur[1];
        if(arr[x][y] == 1){
            right(x,y);
            dfs(depth+1);
            reverseRight(x,y);

            down(x,y);
            dfs(depth+1);
            reverseDown(x,y);

            left(x,y);
            dfs(depth+1);
            reverseLeft(x,y);

            up(x,y);
            dfs(depth+1);
            reverseUp(x,y);
        }
        else if(arr[x][y] == 2){
            right(x,y);
            left(x,y);
            dfs(depth+1);
            reverseRight(x,y);
            reverseLeft(x,y);

            up(x,y);
            down(x,y);
            dfs(depth+1);
            reverseDown(x,y);
            reverseUp(x,y);

        }
        else if(arr[x][y] == 3){
            up(x,y);
            right(x,y);
            dfs(depth+1);
            reverseRight(x,y);
            reverseUp(x,y);

            right(x,y);
            down(x,y);
            dfs(depth+1);
            reverseDown(x,y);
            reverseRight(x,y);

            left(x,y);
            down(x,y);
            dfs(depth+1);
            reverseDown(x,y);
            reverseLeft(x,y);

            up(x,y);
            left(x,y);
            dfs(depth+1);
            reverseUp(x,y);
            reverseLeft(x,y);
        }
        else if(arr[x][y] == 4){
            up(x,y);
            right(x,y);
            left(x,y);
            dfs(depth+1);
            reverseRight(x,y);
            reverseUp(x,y);
            reverseLeft(x,y);

            up(x,y);
            right(x,y);
            down(x,y);
            dfs(depth+1);
            reverseDown(x,y);
            reverseRight(x,y);
            reverseUp(x,y);

            right(x,y);
            left(x,y);
            down(x,y);
            dfs(depth+1);
            reverseDown(x,y);
            reverseLeft(x,y);
            reverseRight(x,y);

            down(x,y);
            up(x,y);
            left(x,y);
            dfs(depth+1);
            reverseUp(x,y);
            reverseLeft(x,y);
            reverseDown(x,y);

        }
        else if(arr[x][y] == 5){
            right(x,y);
            down(x,y);
            left(x,y);
            up(x,y);
            dfs(depth+1);
            reverseRight(x,y);
            reverseDown(x,y);
            reverseLeft(x,y);
            reverseUp(x,y);
        }
    }

    private static void reverseUp(int x, int y) {
        for (int i = x-1; i >=0; i--) {
            if(arr[i][y] == 6) break;
            if(arr[i][y] <0) arr[i][y] += 1;
        }
    }

    private static void up(int x, int y) {
        for (int i = x-1; i >= 0; i--) {
            if (arr[i][y] == 6) break;
            if (arr[i][y] <= 0) arr[i][y] -= 1;
        }
    }

    private static void reverseLeft(int x, int y) {
        for (int i = y-1; i >= 0; i--) {
            if(arr[x][i] == 6) break;
            if(arr[x][i] <0) arr[x][i] += 1;
        }
    }

    private static void left(int x, int y) {
        for (int i = y-1; i >= 0; i--) {
            if(arr[x][i] == 6) break;
            if(arr[x][i] <=0) arr[x][i] -= 1;
        }
    }

    private static void reverseDown(int x, int y) {
        for (int i = x+1; i < N; i++) {
            if(arr[i][y] == 6) break;
            if(arr[i][y] < 0) arr[i][y] += 1;
        }
    }

    private static void down(int x, int y) {
        for (int i = x+1; i < N; i++) {
            if(arr[i][y] == 6) break;
            if(arr[i][y] <=0) arr[i][y] -= 1;
        }
    }

    private static void reverseRight(int x, int y) {
        for (int i = y+1; i < M; i++) {
            if(arr[x][i] == 6) break;
            if(arr[x][i] <0) arr[x][i] += 1;
        }
    }
    private static void right(int x, int y) {
        for (int i = y+1; i < M; i++) {
            if(arr[x][i] == 6) break;
            if(arr[x][i] <=0) arr[x][i] -= 1;
        }
    }

    private static void check() {
        int sum = 0;
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) sum++;
            }
        }
        res = Math.min(res, sum);
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}

