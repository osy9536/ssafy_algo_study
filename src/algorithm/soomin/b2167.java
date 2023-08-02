package algorithm.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2167 {

    /*
    * 실버 5 2차원 배열의 합
    * BufferedReader 아직 익숙하지가 않아, 값을 받을 때 마다, StringTokenizer에 새 할당을 받았는데,
    * 반복문으로 한줄 씩 받아서 변수에 집어넣는 법 있을까요?
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K;


        int [][]arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for (int I = 0; I < K; I++) {
            st = new StringTokenizer(br.readLine());
            int sum =0;
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int k = (i-1); k <= (x-1); k++) {
                for (int l = (j-1); l <= (y-1); l++) {
                    sum += arr[k][l];
                }
            }
            System.out.println(sum);
        }


    }

}

