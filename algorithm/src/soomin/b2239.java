package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2239 {
    // index는 숫자, 값은 해당 숫자를 사용 했는지 여부


    static int [][] sudoku = new int[9][9];
    static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                int value = Character.getNumericValue(s.charAt(j));
                sudoku[i][j] = value;
            }
        }

        dfs(0);


    }

    public static void dfs(int deepth){

        if(deepth == 81){
            isEnd = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j]);
                }
                System.out.println();
            }
            return;
        }

        // 스도쿠 상 위치 구하기
        int row = deepth/9;
        int col = deepth%9;

        if(sudoku[row][col] != 0){
            dfs(deepth+1);
        }

        // 스도쿠 상 해당 위치가 0일 경우 유효한 스도쿠가 될 때까지 1~9 넣어보는 식
        else{
            for (int i = 1; i <= 9; i++) {
                if(!isValid(row,col,i)) {
                    continue;
                }

                else{
                    sudoku[row][col] = i;
                    dfs(deepth+1);

                    // 만약 대망의 81까지 갔다면 더 이상 진행안하고 dfs를 종료한다.
                    if(isEnd) return;
                    else {
                        // 스도쿠에 해당값을 넣을 당시에는 유효했으나, 계속 진행해보니, 안되서
                        // 그 값이 아닌 다른 값을 넣고 진행해봐야 해서 해당 값을 0으로 바꾼다.
                        sudoku[row][col] = 0;
                    }
                }
            }
        }
    }

    public static boolean isValid(int r, int c, int target){
        for (int i = 0; i < 9; i++) {
            // 같은 행 중에 같은 값이 있으면 유효하지 않다. 넘어간다.
            if(sudoku[r][i] == target){
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if(sudoku[i][c] == target){
                return false;
            }
        }

        int rr = r/3;
        int cc = c/3;

        for (int i = 3*rr; i <= 3*rr+2; i++) {
            for (int j = 3*cc; j <= 3*cc+2; j++) {
                if(sudoku[i][j] == target) {
                    return false;
                }
            }
        }

        return true;
    }
}
