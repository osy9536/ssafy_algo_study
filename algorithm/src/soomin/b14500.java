import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 테트로미노
 * 1 ~ 4번 패턴, dfs로 풀기 -> 모든 경우가 dfs로 나온다.
 * 5번 패턴은 4개 중 3개의 점을 조합으로 구해서 풀기
 * */

public class Main {


    static int N, M;
    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};
    static int [][] arr;

    static boolean [][] isVisited;

    static int max = 0;

    public static void main(String[] args) throws IOException {

        // 1. 값 입력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int [N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                isVisited[i][j] = true;
                // 1 ~ 4 번 패턴 계산
                dfs(i,j,0,arr[i][j]);
                Combination(i,j,0,0,arr[i][j]);
                // 5번 패턴 계산

                isVisited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static void dfs (int x, int y, int depth, int sum){

        // (1) 기저 조건
        if(depth == 3){
            max = Math.max(max, sum);
            return;
        }

        // (2) 계산 하는 곳
        for (int i = 0; i < 4; i++) {

            int nx = x + idx[i];
            int ny = y + idy[i];

            // 유효성 검증 -> dfs로 나아가려는 지점이 2차원 배열에 속하는 지점이면 유효함으로, 다음 DFS로 나아갈 자격이 있다.
            if (nx >= 0 && ny >= 0 && nx < N && ny < M){
                if(!isVisited[nx][ny]){
                    isVisited[nx][ny] = true;
                    dfs(nx,ny,depth+1, sum+arr[nx][ny]);
                    isVisited[nx][ny] = false;
                }
            }
        }
    }

    // 5번 패턴 용 조합

    public static void Combination (int x, int y, int depth, int start, int sum) {

        // (1) 기저 조건
        if(depth == 3){
            max = Math.max(max, sum);
            return;
        }


        // (2) 계산
        for (int i = start; i < 4; i++) {

            int nx = x + idx[i];
            int ny = y + idy[i];

            if( nx >= 0 && ny >= 0 && nx < N && ny < M) {
                Combination(x,y,depth+1, i+1, sum + arr[nx][ny]);
            }
        }
    }
}
