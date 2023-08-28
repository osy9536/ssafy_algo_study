package algorithm.src.ohseyoung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ⚾
// gold 4
public class b17281 {
    static int[][] inning;
    static boolean[] select; // 아래 순열에서 사용될 boolean 타입 배열
    static int[] order; // 타순
    static int answer, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inning = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        select = new boolean[10];
        order = new int[10];

        // 4번 타자는 1번으로 고정
        select[4] = true;
        order[4] = 1;

        answer = 0;
        permutaion(2);
        System.out.println(answer);
    }

    private static void permutaion(int num) {
        if (num == 10) {
            solve();
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!select[i]) {
                select[i] = true;
                order[i] = num;
                permutaion(num + 1);
                select[i] = false;
            }
        }
    }

    private static void solve() {
        int score = 0;
        int startPlayer = 1;
        boolean[] base;
        for (int i = 1; i <= N; i++) {
            int outCnt = 0;
            base = new boolean[4];
            // outer라는 while문의 이름 설정
            outer:
            while (true) {
                for (int j = startPlayer; j <= 9; j++) {
                    int curPlayer = inning[i][order[j]];
                    if (curPlayer == 0) {
                        outCnt++;
                    }
                    if (curPlayer == 1) {
                        for (int k = 3; k >= 1; k--) {
                            if (base[k]) {
                                if (k == 3) {
                                    score++;
                                    base[k] = false;
                                } else {
                                    base[k] = false;
                                    base[k + 1] = true;
                                }
                            }
                        }
                        base[1] = true;
                    }
                    if (curPlayer == 2) {
                        for (int k = 3; k >= 1; k--) {
                            if (base[k]) {
                                if (k == 2 || k == 3) {
                                    score++;
                                    base[k] = false;
                                } else {
                                    base[k] = false;
                                    base[k + 2] = true;
                                }
                            }
                        }
                        base[2] = true;
                    }
                    if (curPlayer == 3) {
                        for (int k = 3; k >= 1; k--) {
                            if (base[k]) {
                                score++;
                                base[k] = false;
                            }
                        }
                        base[3] = true;
                    }
                    if (curPlayer == 4) {
                        for (int k = 1; k <= 3; k++) {
                            if (base[k]) {
                                score++;
                                base[k] = false;
                            }
                        }
                        score++;
                    }
                    if (outCnt == 3) {
                        startPlayer = j + 1;
                        if (startPlayer == 10) {
                            startPlayer = 1;
                        }
                        break outer;
                    }
                }
                startPlayer = 1;
            }
        }
        answer = Math.max(answer, score);
    }
}

