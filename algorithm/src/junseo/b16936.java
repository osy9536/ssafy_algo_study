package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NotLinkException;
import java.util.StringTokenizer;

public class b16935 {

    static int N,M,R,A;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            A = Integer.parseInt(st.nextToken());
            if(A == 1) {
                updownInversion();
            }else if(A == 2) {
                leftRightInversion();
            }else if(A == 3) {
                turnRight();
            }else if(A == 4) {
                turnLeft();
            }else if(A == 5) {
                five();
            }else if(A == 6) {
                six();
            }
        }
        print();

    }

    private static void six() {
        int [][]temp = new int[N][M];
        int nN = N/2;
        int mM = M/2;

        for (int i = 0; i < nN; i++) {
            for (int j = 0; j < mM ; j++) {
                temp[i+nN][j] = arr[i][j];
            }
        }
        for (int i = nN; i < N; i++) {
            for (int j = 0; j < mM ; j++) {
                temp[i][j+mM] = arr[i][j];
            }
        }
        for (int i = nN; i < N; i++) {
            for (int j = mM; j < M ; j++) {
                temp[i-nN][j] = arr[i][j];
            }
        }
        for (int i = 0; i < nN; i++) {
            for (int j = mM; j < M ; j++) {
                temp[i][j-mM] = arr[i][j];
            }
        }
        arr = temp;
    }


    private static void five() {
        int [][]temp = new int[N][M];
        int nN = N/2;
        int mM = M/2;

        for (int i = 0; i < nN; i++) {
            for (int j = 0; j < mM ; j++) {
                temp[i][j+mM] = arr[i][j];
            }
        }
        for (int i = 0; i < nN; i++) {
            for (int j = mM; j < M ; j++) {
                temp[i+nN][j] = arr[i][j];
            }
        }
        for (int i = nN; i < N; i++) {
            for (int j = mM; j < M ; j++) {
                temp[i][j-mM] = arr[i][j];
            }
        }
        for (int i = nN; i < N; i++) {
            for (int j = 0; j < mM ; j++) {
                temp[i-nN][j] = arr[i][j];
            }
        }
        arr = temp;
    }

    private static void turnLeft() {
        int [][]temp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <M ; j++) {
                temp[M-j-1][i] = arr[i][j];
            }
        }
        int a = N;
        N = M;
        M = a;
        arr = temp;
    }
    private static void turnRight() {
        int [][]temp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <M ; j++) {
                temp[j][N-i-1] = arr[i][j];
            }
        }
        int a = N;
        N = M;
        M = a;
        arr = temp;
    }



    private static void leftRightInversion() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][M-1-j];
                arr[i][M-1-j] = temp;
            }
        }
    }

    private static void updownInversion() {
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[N-1-i][j];
                arr[N-1-i][j] = temp;
            }
        }
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

