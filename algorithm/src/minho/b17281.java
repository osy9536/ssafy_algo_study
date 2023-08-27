package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//순열 짜는 함수
//체크 하는 함수
//max 최신화 하는 함수
public class b17281 {
    static int N, Max = Integer.MIN_VALUE;
    static int[][] arr;
    static int[] P = new int[9];
    static boolean[] visited = new boolean[9];
    static boolean[] four = new boolean[3];
    static int sum = 0;

    public static int find() {
        int c = 0;
        for (int i = 0; i < 3; i++) {
            if (four[i]) c++;
        }
        return c;
    }

    public static void check(int e, int saved) {
        if (e == N) {
            Max = (sum > Max) ? sum : Max;
            sum = 0;
            return;
        }
        Arrays.fill(four, false);
        int cnt = 0, i = saved;
        while (true) {
            if (cnt == 3) break;
            if (i >= 9) i %= 9;
            if (arr[e][P[i]] == 0) {
                i++;
                cnt++;
            } else {
                if (arr[e][P[i]] == 4) {
                    sum += find() + 1;
                    four[2] = four[0] = four[1] = false;
                } else if (arr[e][P[i]] == 3) {
                    sum += find();
                    four[0] = four[1] = false;
                    four[2] = true;
                } else if (arr[e][P[i]] == 2) {
                    if (four[2]) {
                        four[2] = false;
                        sum += 1;
                    }
                    if (four[1]) {
                        four[1] = false;
                        sum += 1;
                    }
                    if (four[0]) {
                        four[2] = true;
                        four[0] = false;
                    }
                    four[1] = true;
                } else if (arr[e][P[i]] == 1) {
                    if (four[2]) {
                        four[2] = false;
                        sum += 1;
                    }
                    if (four[1]) {
                        four[2] = true;
                        four[1] = false;
                    }
                    if (four[0]) {
                        four[1] = true;
                        four[0] = false;
                    }
                    four[0] = true;
                }
                i++;
            }
        }
        check(e + 1, i);
    }

    public static void permutation(int count) {
        if (count == 9) {
            check(0, 0);
            return;
        }
        if(count ==3 )
            count++;
        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                P[count] = i;
                permutation(count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][9];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        P[3] = 0;
        visited[0] = true;
        permutation(0);
        System.out.println(Max);
    }
}
