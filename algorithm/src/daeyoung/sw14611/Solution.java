package algorithm.src.daeyoung.sw14611;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static BufferedReader br;
    private static UserSolution usersolution = new UserSolution();

    private final static int CMD_INIT = 100;
    private final static int CMD_PUT = 200;
    private final static int CMD_FIND = 300;
    private final static int CMD_CHANGE = 400;

    private final static int MAX_CARD_NUM = 5;
    private final static int MAX_RET_NUM = 4;

    private final static int numbers[] = new int[MAX_CARD_NUM];
    private final static int ret_numbers[] = new int[MAX_RET_NUM];
    private final static int ans_numbers[] = new int[MAX_RET_NUM];

    private static boolean run() throws Exception {

        StringTokenizer stdin = new StringTokenizer(br.readLine(), " ");

        int query_num = Integer.parseInt(stdin.nextToken());
        int ret, ans;
        boolean ok = false;

        for (int q = 0; q < query_num; q++) {
            stdin = new StringTokenizer(br.readLine(), " ");
            int query = Integer.parseInt(stdin.nextToken());

            if (query == CMD_INIT) {
                int joker = Integer.parseInt(stdin.nextToken());
                for (int i = 0; i < MAX_CARD_NUM; i++)
                    numbers[i] = Integer.parseInt(stdin.nextToken());
                usersolution.init(joker, numbers);
                ok = true;
            } else if (query == CMD_PUT) {
                int dir = Integer.parseInt(stdin.nextToken());
                for (int i = 0; i < MAX_CARD_NUM; i++)
                    numbers[i] = Integer.parseInt(stdin.nextToken());
                usersolution.putCards(dir, numbers);
            } else if (query == CMD_FIND) {
                int num, Nth;
                num = Integer.parseInt(stdin.nextToken());
                Nth = Integer.parseInt(stdin.nextToken());
                ans = Integer.parseInt(stdin.nextToken());
                ret = usersolution.findNumber(num, Nth, ret_numbers);
                if (ans != ret) {
                    ok = false;
                }
                if (ans == 1) {
                    for (int i = 0; i < MAX_RET_NUM; i++) {
                        ans_numbers[i] = Integer.parseInt(stdin.nextToken());
                        if (ans_numbers[i] != ret_numbers[i]) {
                            ok = false;
                        }
                    }
                }
            } else if (query == CMD_CHANGE) {
                int value = Integer.parseInt(stdin.nextToken());
                usersolution.changeJoker(value);
            }

        }
        return ok;
    }

    public static void main(String[] args) throws Exception {
        int T, MARK;

        // System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stinit = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(stinit.nextToken());
        MARK = Integer.parseInt(stinit.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            int score = run() ? MARK : 0;
            System.out.println("#" + tc + " " + score);
        }

        br.close();
    }
}
