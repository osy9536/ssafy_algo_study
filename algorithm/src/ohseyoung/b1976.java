package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 여행가자
// gold4
public class b1976 {

    static boolean[][] connect;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        connect = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());

                if (a == 1) {
                    connect[i][j] = true;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (connect[i][k] && connect[k][j]) {
                        connect[i][j] = true;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }

        boolean ans = false;
        for (int i = 0; i < m - 1; i++) {
            if (!connect[arr[i]-1][arr[i + 1]-1]) {
                ans = true;
                break;
            }
        }
        if (n == 1) {
            System.out.println("YES");
            System.exit(0);
        }
        if (ans) {
            System.out.println("NO");
        }else System.out.println("YES");
    }
}
