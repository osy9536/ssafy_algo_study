package algorithm.src.daeyoung;

import java.util.*;

/**
 * 프로그래머스 - [1차] 프렌즈4블록
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/17679
 */
public class p17679 {

    static boolean[][] check;
    static char[][] boards;

    public static void main(String[] args) {
        int m = 6;
        int n = 6;

        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        int answer = 0;
        check = new boolean[m][n];

        for(int i = 0; i < m; i++)
            Arrays.fill(check[i], false);

        boards = new char[m][n];

        for(int i = 0; i < m; i++) {
            boards[i] = board[i].toCharArray();
        }

        int cnt = deleteBlock(m, n);

        while(cnt > 0) {
            answer += cnt;

            //블럭 내리기
            downBlock(m, n);

            //방문 초기화
            check = new boolean[m][n];
            for(int i = 0; i < m; i++)
                Arrays.fill(check[i], false);

            //다음 삭제 블럭 세기
            cnt = deleteBlock(m, n);
        }

        System.out.println(answer);
    }

    public static int deleteBlock(int m, int n) {
        int cnt = 0;

        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(boards[i][j]!= 'b')
                    checkDelete(i, j, m, n);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(check[i][j]) {
                    cnt++;
                    boards[i][j] = 'b';
                }

            }
        }

        return cnt;
    }

    public static boolean checkDelete(int r, int c, int m, int n) {
        char cur = boards[r][c];

        for(int i = r; i < r + 2; i++) {
            for(int j = c; j < c + 2; j++) {
                if(boards[i][j] != cur)
                    return false;
            }
        }

        for(int i = r; i < r + 2; i++) {
            for(int j = c; j < c + 2; j++) {
                check[i][j] = true;
            }
        }

        return true;
    }

    public static void downBlock(int m, int n) {

        for(int j = 0; j < n; j++) {
            for(int i = m - 1; i >= 0; i--) {

                if(boards[i][j] == 'b') {
                    int blankI = checkBlank(i, j, m, n);
                    if(blankI > -1) {
                        boards[i][j] = boards[blankI][j];
                        boards[blankI][j] = 'b';
                    } else
                        break;
                }
            }
        }
    }

    public static int checkBlank(int r, int c, int m, int n) {
        for(int i = r; i >= 0; i--) {
            if(boards[i][c] != 'b')
                return i;
        }

        return -1;
    }
}
