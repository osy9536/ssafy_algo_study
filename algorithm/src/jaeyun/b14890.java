package algorithm.src.jaeyun;

import java.util.Scanner;

public class b14890 {
    static int N, L, ans;
    static int[][] map;
    static int[] mark;

    private static void initMark() {
        for (int i=0; i<100; i++)
            mark[i] = 0;
    }

    private static void scanLeftToRight() {
        for (int x=0; x<N; x++) { // left to right
            boolean success = true;
            initMark();
            for (int y=1; y<N; y++) {
                success = true;
                if (mark[y] == 1)
                    continue;
                else if (map[x][y-1] - 1 == map[x][y] && y+L <= N) { // descending
                    // check if following L blocks have the same level
                    boolean impossible = false;
                    for (int yy=y; yy<y+L; yy++) {
                        if (map[x][y] != map[x][yy]) {
                            impossible = true;
                            break;
                        }
                    }
                    if (!impossible) {
                        for (int yy=y; yy<y+L; yy++)
                            mark[yy] = 1;
                    } else {
                        success = false;
                        break;
                    }
                } else if (map[x][y-1] + 1 == map[x][y] && y - L >= 0) { // ascending
                    // check if previous L blocks have the same level
                    boolean impossible = false;
                    for (int yy=y-1; yy>y-L-1; yy--) {
                        if (map[x][y-1] != map[x][yy] || mark[yy] == 1) {
                            impossible = true;
                            break;
                        }
                    }
                    if (!impossible) {
                        for (int yy=y-1; yy>y-L-1; yy--)
                            mark[yy] = 1;
                    } else {
                        success = false;
                        break;
                    }
                } else if (map[x][y-1] == map[x][y])
                    continue;
                else {
                    success = false;
                    break;
                }
            }
            if (success)
                ans += 1;
        }
    }

    private static void transposeMap() {
        int[][] tmp = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                tmp[i][j] = map[j][i];
            }
        }
        for (int i=0; i<N; i++) {
            System.arraycopy(tmp[i], 0, map[i], 0, N);
        }
    }

    public static void main(String[] args) {
        ans = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        map = new int[N][N];
        mark = new int[100];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        initMark();
        scanLeftToRight();
        transposeMap();
        scanLeftToRight();
        System.out.println(ans);
    }
}
