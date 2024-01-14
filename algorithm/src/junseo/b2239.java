package algorithm.src.junseo;
import java.io.*;
import java.util.*;

public class b2239 {
  static int[][] board = new int[9][9];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 9; i++) {
      String str = br.readLine();
      for (int j = 0; j < 9 ; j++) {
        board[i][j] = str.charAt(j)-'0';
      }
    }
    solDfs(0,0);
  }

  private static void solDfs(int row, int col) {
    if(row == 9){
      printBoard();
      System.exit(0);
    }
    if(col == 9){
      solDfs(row+1,0);
      return;
    }
    if(board[row][col] == 0){
      for (int i = 1; i <= 9; i++) {
        if(isValid(row,col,i)){
          board[row][col] = i;
          solDfs(row,col+1);
          board[row][col] = 0;
        }
      }
    }
    else{
      solDfs(row,col+1);
    }

  }

  private static boolean isValid(int row, int col, int num) {
    // Check row and column
    for (int i = 0; i < 9; i++) {
      if(board[row][i] == num || board[i][col] == num){
        return false;
      }
    }
    // Check 3x3 grid
    int startRow = row - row%3;
    int startCol = col - col%3;
    for (int i = startRow; i <startRow+3 ; i++) {
      for (int j = startCol; j <startCol+3 ; j++) {
        if (board[i][j] == num){
          return false;
        }
      }
    }
    return true;
  }

  private static void printBoard() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <9 ; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(board[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }


}


