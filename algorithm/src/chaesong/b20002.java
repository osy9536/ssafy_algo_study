import java.util.*;
import java.io.*;

public class Main {
    static int N, max;
    static int[][] arr, hap;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        arr = new int[N+1][N+1];
        hap = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                hap[i][j] = hap[i][j-1] + hap[i-1][j] - hap[i-1][j-1] + arr[i][j];
            }
        }
        maxV();
        System.out.println(max);
    }
    static void maxV(){
        int n = 2;
        while(n <= N){
            for(int i = 1; i <= N-n+1; i++){
                for(int j = 1; j <= N-n+1; j++){
                    int temp = hap[i+(n-1)][j+(n-1)] - hap[i-1][j+(n-1)] - hap[i+(n-1)][j-1] + hap[i-1][j-1];
                    max = Math.max(max, temp);
                }
            }
            n++;
        }
    }
}
