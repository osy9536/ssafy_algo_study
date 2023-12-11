package algorithm.src.daeyoung;

import java.util.*;
import java.io.*;

/**
 * 백준 25682
 * 체스판 다시 칠하기2
 * 골드 5
 * https://www.acmicpc.net/problem/25682
 */
public class b25682 {

    static int n; //보드 세로
    static int m; //보드 가로
    static int k; //체스판 크기
    static char[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for(int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());

            board[i] = st.nextToken().toCharArray();
        }

        int[][] black = prefixSum('B');
        int[][] white = prefixSum('W');

//        for (int i = 0; i <= n; i++) {
//            System.out.println(Arrays.toString(black[i]));
//        }
//        System.out.println();
//        for (int i = 0; i <= n; i++) {
//            System.out.println(Arrays.toString(white[i]));
//        }

        int answer = Integer.MAX_VALUE;
        int bTemp = Integer.MAX_VALUE;
        int wTemp = Integer.MAX_VALUE;

        for(int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                bTemp = Math.min(bTemp, black[i][j] - black[i][j - k] - black[i - k][j]
                        + black[i - k][j - k]);
                wTemp = Math.min(wTemp, white[i][j] - white[i][j - k] - white[i - k][j]
                        + white[i - k][j - k]);

                answer = Math.min(bTemp, wTemp);

//                System.out.println(bTemp + " " + wTemp + " " + answer);
            }
        }

        System.out.println(answer);
    }

    public static int[][] prefixSum(char color) {
        int[][] value = new int[n + 1][m + 1];

        for(int i = 0; i < n; i++) {
            char temp = color;
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if(temp != board[i][j])
                    cnt++;
                if(temp == 'W')
                    temp = 'B';
                else
                    temp = 'W';

                if(i == 0) {
                    value[i + 1][j + 1] = cnt;
                    continue;
                }

                value[i + 1][j + 1] += cnt + value[i][j + 1];
            }
            if(color == 'W')
                color = 'B';
            else
                color = 'W';
        }

        return value;
    }

}
