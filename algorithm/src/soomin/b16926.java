package algorithm.src.soomin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;



public class b16926  {
    //N == 세로, M == 가로, R == 회전
    static int N;
    static int M;
    static int R;
    static int [][] arr;
    // 오른쪽으로 한칸, 밑으로 한칸, 왼쪽으로 한칸, 위로 한칸
    static int [] nh = {0,1,0,-1};
    static int [] nv = {1,0,-1,0};


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int [N][M];
        // 값 넣기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Math.min(N, M);
        for(int k = 0; k < R; k++) {
            for(int i = 0; i <min/2; i++) {
                spin(i);
            }
        }

        for(int [] a : arr) {
            for(int tt : a) {
                System.out.print(tt + " ");
            }
            System.out.println();
        }
    }

    // 딱 배열의 모든 순환을 반시계 방향으로 한 칸 움직임
    public static void spin(int cnt) {

        // start 위치
        int x = cnt;
        int y = cnt;

        // start 위치는 바로 덮어쓰기 되므로 값을 딴 곳에 저장
        int temp = arr[x][y];

        // idx는 사방위로 간다. 오른쪽으로, 밑으로, 왼쪽으로, 위로
        int idx = 0;
        while(idx <4) {
            // next x와 next y 값
            int nx = x+nh[idx];
            int ny = y+nv[idx];

            // 다음 배열이 있는 경우에만 계속 ㄲㄲ
            if(nx<N-cnt && ny<M-cnt && nx>=cnt && ny>=cnt) {
                arr[x][y] = arr[nx][ny];
                x = nx;
                y = ny;
            }

            else {
                idx++;
            }
        }

        // 맨 마지막에 자리에 아까 저장해둔 값 옮기기
        arr[cnt+1][cnt] = temp;
    }
}
