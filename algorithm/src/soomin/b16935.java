package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b16935 {
    static int[][] arr;
    static int N,M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N,M == 가로 세로, R == 연산의 횟수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 배열 할당
        arr = new int[N][M];

        // 배열에 값 담기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령어 라인의 글들을 읽어오기
        st= new StringTokenizer(br.readLine());


        // 명령어 실행
        for(int i = 0; i < R; i ++) {
            int order = Integer.parseInt(st.nextToken());

            switch(order){
                case 1:
                    Order1();
                    break;
                case 2:
                    Order2();
                    break;
                case 3:
                    Order3();
                    break;
                case 4:
                    Order4();
                    break;
                case 5:
                    Order5();
                    break;
                case 6:
                    Order6();
                    break;
            }
        }

        // 출력
        for(int [] a : arr) {
            for(int t : a) {
                System.out.print(t + " ");
            }
            System.out.println();
        }

    }

    // 명령 1 -> 상하 반전
    public static void Order1() {

        // 위 한줄을 임시 일차원 배열에 넣고, N = temp, N = M, M = temp 시전
        for(int i = 0; i < arr.length/2; i++) {
            int [] a = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = a;
        }
    }

    public static void Order2() {


        for(int k = 0; k < arr[0].length/2; k++) {

            // 좌 한줄 - a배열, 우 한줄 -b배열 생성
            int [] a= new int[arr.length];
            int [] b= new int[arr.length];

            // 각 배열에 값 담기
            for(int i = 0; i <arr.length; i++) {
                a[i] = arr[i][k];
                b[i] = arr[i][arr[0].length-1-k];
            }

            // 좌 한줄은 arr 오른쪽에, 우 한줄은 arr 왼쪽에 대입
            for(int i = 0; i < arr.length; i++) {
                arr[i][arr[0].length-1-k] = a[i];
                arr[i][k] = b[i];
            }
        }
    }

    public static void Order3() {

        // 뒤집었기에 가로 세로 반전
        int b[][] = new int[arr[0].length][arr.length];

        // 원래 값을 다시 배열 안에 넣어야 하므로 , 루프는 원래 배열의 가로 세로 기준
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                b[j][arr.length-1-i] = arr[i][j];
            }
        }

        // 기존의 arr을 가로와 세로가 바뀐 새로운 배열로 만들어주기
        arr = new int[b.length][b[0].length];

        // arr에 90도 회전한 배열 넣어주기
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = b[i][j];
            }
        }
    }

    // 명령어3과 동일
    public static void Order4() {
        int b[][] = new int[arr[0].length][arr.length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                b[arr[0].length-1-j][i] = arr[i][j];
            }
        }

        arr = new int[b.length][b[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = b[i][j];
            }
        }
    }


    public static void Order5(){
        // 4등분 한다.
        int [][] p1 = new int[arr.length/2][arr[0].length/2];
        int [][] p2 = new int[arr.length/2][arr[0].length/2];
        int [][] p3 = new int[arr.length/2][arr[0].length/2];
        int [][] p4 = new int[arr.length/2][arr[0].length/2];

        // V == 행을 반으로 가른 것, H는 열을 반으로 가른 것
        int [] V = new int[] {arr.length/2, arr.length-1};
        int [] H = new int[] {arr[0].length/2, arr[0].length-1};


        // 4등분 하여 각 작은 배열 4개에 집어넣기
        for(int i = 0; i < V[0]; i++) {
            for (int j = 0; j < H[0]; j++) {
                p1[i][j] = arr[i][j];
                p2[i][j] = arr[i][H[0]+j];
                p3[i][j] = arr[V[0]+i][j];
                p4[i][j] = arr[V[0]+i][H[0]+j];
            }
        }

        // 받은 값들을 다시 arr에 집어넣기
        for(int i = 0; i < V[0]; i++) {
            for (int j = 0; j < H[0]; j++) {
                arr[i][j] = p3[i][j];
                arr[i][H[0]+j] = p1[i][j];
                arr[V[0]+i][j] = p4[i][j];
                arr[V[0]+i][H[0]+j] = p2[i][j];
            }
        }
    }

    public static void Order6(){
        int [][] p1 = new int[arr.length/2][arr[0].length/2];
        int [][] p2 = new int[arr.length/2][arr[0].length/2];
        int [][] p3 = new int[arr.length/2][arr[0].length/2];
        int [][] p4 = new int[arr.length/2][arr[0].length/2];

        int [] V = new int[] {arr.length/2, arr.length-1};
        int [] H = new int[] {arr[0].length/2, arr[0].length-1};


        for(int i = 0; i < V[0]; i++) {
            for (int j = 0; j < H[0]; j++) {
                p1[i][j] = arr[i][j];
                p2[i][j] = arr[i][H[0]+j];
                p3[i][j] = arr[V[0]+i][j];
                p4[i][j] = arr[V[0]+i][H[0]+j];
            }
        }

        for(int i = 0; i < V[0]; i++) {
            for (int j = 0; j < H[0]; j++) {
                arr[i][j] = p2[i][j];
                arr[i][H[0]+j] = p4[i][j];
                arr[V[0]+i][j] = p1[i][j];
                arr[V[0]+i][H[0]+j] = p3[i][j];
            }
        }
    }

}