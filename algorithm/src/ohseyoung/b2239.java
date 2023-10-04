package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 스도쿠
// gold 4
public class b2239 {
    static int[][] arr;
    static boolean[][] isZero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        isZero = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
            String n = br.readLine();
            for (int j = 0; j < 9; j++) {
                int a = n.charAt(j) - '0';
                arr[i][j] = a;
                if (a == 0) {
                    isZero[i][j] = true;
                }
            }
        }

        sudoku(0, 0);
    }

    static void sudoku(int row, int col) {
        // 모든 칸을 검사한 경우, 결과 출력
        if (row == 9) {
            printSolution();
            System.exit(0);
        }

        // 현재 칸이 0이 아니면 다음 칸으로 이동
        if (!isZero[row][col]) {
            moveNext(row, col);
            return;
        }

        // 0인 경우 1부터 9까지의 숫자를 시도
        for (int num = 1; num <= 9; num++) {
            if (isValid(num, row, col)) {
                arr[row][col] = num;
                moveNext(row, col);
                arr[row][col] = 0; // 백트래킹
            }
        }
    }

    static void moveNext(int row, int col) {
        if (col == 8) {
            sudoku(row + 1, 0);
        } else {
            sudoku(row, col + 1);
        }
    }

    static boolean isValid(int num, int row, int col) {
        // 같은 행 검사
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == num) {
                return false;
            }
        }

        // 같은 열 검사
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == num) {
                return false;
            }
        }

        // 같은 3x3 영역 검사
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    static void printSolution() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
