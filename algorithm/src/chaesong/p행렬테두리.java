import java.util.*;

class Solution {
    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows+1][columns+1];
        int[] answer = new int[queries.length];
        
        int idx =1;
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                arr[i][j] = idx++;
            }
        }
        
        
        for(int i = 0; i < queries.length; i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            
            answer[i] = rotate(x1, y1, x2, y2);
        }
        return answer;
    }
    
    static int rotate(int x1, int y1, int x2, int y2){
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        
        int x = x1; int y = y1;
        int dir = 3; // 나보다 밑에 있는 애가 내 자리에
        int temp = arr[x1][y1];
        int min_v = temp;
        while(true){
            if(x==x2 && y==y1) dir = 0; // 나보다 오른쪽에 있는 거
            if(x==x2 && y==y2) dir = 1; // 나보다 위에 있는거
            if(x==x1 && y==y2) dir = 2; // 나보다 왼쪽에 있는 거
            
            arr[x][y] = arr[x+dx[dir]][y+dy[dir]];
            x += dx[dir];
            y += dy[dir];
            min_v = Math.min(min_v, arr[x][y]);
            
            // 출발점으로 돌아오면
            if(x==x1 && y==y1){
                arr[x1][y1+1] = temp;
                break;
            }
        }
        
        return min_v;
    }
}
