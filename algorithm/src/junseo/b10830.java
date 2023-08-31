package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10830 {

    static int N;
    static  long B;
    static int [][] origin;
    static int [][] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        origin = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }
        ////////////////////////////////////////////////////////////////////////
        res = new int[N][N];
        res = sol(B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static  int [][] sol(long b) {
        if(b == 1) return origin;
        int [][] temp = sol(b/2);
        temp = matrixMul(temp,temp);

        if(b % 2 ==1) {
          temp = matrixMul(temp,origin);
        }

        return temp;

    }

    private static int[][] matrixMul(int[][] arr,int[][] arr2) {
        int [][] sum = new int[N][N];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k <N ; k++) {
                    sum[i][j] += (arr[i][k] *arr2[k][j]);
                }
                sum[i][j] %= 1000;
            }
        }
        return sum;
    }
}


