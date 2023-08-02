package algorithm.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16926 {
    static int N,M;
    static int [][] arr;
    static int min;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        min = Math.min(N,M);
        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<R;i++){
            Rotation();
        }

        for(int i = 0; i<N;i++){
            for(int j = 0; j<M;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }

    }

    static void Rotation(){
        for(int i = 0; i<min/2;i++){ // N,M중 작은 값 만큼 반복
            int x = i;
            int y = i;
            int temp = arr[x][y];
            int idx =0;
            while (idx <4){
                int nx = x+dx[idx];
                int ny = y+dy[idx];
                if(nx>=i && nx<(N-i)&&ny>=i&&ny<(M-i)){
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                }
                else{
                    idx++;
                }
            }
            arr[i+1][i] = temp;
        }
    }
}

