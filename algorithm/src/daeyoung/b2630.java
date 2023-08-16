package algorithm.src.daeyoung;


import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 2630
 * 색종이 만들기
 * 실버 2
 * https://www.acmicpc.net/problem/2630
 */
public class b2630 {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        slice(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void slice(int r, int c, int n) {
        if(isFull(r, c, n, 1)) {
            white++;
            return;
        }

        if(isFull(r, c, n, 0)) {
            blue++;
            return;
        }

        slice(r, c, n /2);
        slice(r + n / 2, c, n / 2);
        slice(r, c + n / 2, n / 2);
        slice(r + n / 2, c + n /2, n / 2);

    }

    public static boolean isFull(int r, int c, int n, int color) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if(paper[i][j] == color)
                    return false;
            }
        }

        return true;
    }
}
