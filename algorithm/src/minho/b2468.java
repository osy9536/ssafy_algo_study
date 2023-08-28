package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2468 {
    static int N , inputMin = Integer.MAX_VALUE , inputMax = Integer.MIN_VALUE;
    static int[][] map ;
    static boolean[][] copyMap;
    static int[] dx = {0,-1,0,1},dy = {-1,0,1,0};
    public static void DFS(int x, int y){
        for(int i = 0 ; i < 4 ; i++){
            if(x+dx[i]>=0 && x+dx[i]<N && y+dy[i]>=0 && y+dy[i]<N){
                if(copyMap[x+dx[i]][y+dy[i]]){
                    copyMap[x+dx[i]][y+dy[i]]=false;
                    DFS(x+dx[i],y+dy[i]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int answerMax = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken()) ;
                inputMax = (inputMax < map[i][j]) ? map[i][j] : inputMax;
                inputMin = (inputMin > map[i][j]) ? map[i][j] : inputMin;
            }
        }
        copyMap = new boolean[N][N];
        for(int i = inputMin-1; i <= inputMax; i++){
            int cnt = 0;
            for(int x = 0 ; x < N ; x++){
                for( int y = 0 ; y < N ; y++){
                    if(map[x][y]>i){ copyMap[x][y]=true;}
                    else { copyMap[x][y] = false;}
                }
            }
            //맵복사 완료

            for(int x = 0; x < N; x++){
                for(int y = 0 ; y < N ; y++){
                    if(copyMap[x][y]) {
                        DFS(x, y);
                        cnt++;
                    }
                }
            }
            answerMax = (answerMax < cnt) ? cnt : answerMax;
        }
        System.out.println(answerMax);
    }
}