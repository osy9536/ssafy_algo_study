import java.util.*;

class Solution {
    static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean visited[][][];
    
    static class Node{
        String color;
        int x, y, depth;
        Node(String color, int x, int y, int depth){
            this.color = color;
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    static int answer, height, width;
    public int solution(int[][] maze) {
        answer = Integer.MAX_VALUE;
        height = maze.length;
        width = maze[0].length;
        visited = new boolean[2][height][width];
        
        int red_x = 0; int red_y = 0; int blue_x = 0; int blue_y = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(maze[i][j] == 1){
                    red_x = i; red_y = j;
                }else if(maze[i][j] == 2){
                    blue_x = i; blue_y = j;
                }
            }
        }
        
        int[][] start = {{red_x, red_y}, {blue_x, blue_y}};
        
        visited[0][red_x][red_y] = true;
        visited[1][blue_x][blue_y] = true;
        dfs(start, maze, 0);
        return answer == Integer.MAX_VALUE? 0: answer;
    }
    static void dfs(int[][] now, int[][] maze, int cost){
        int rx = now[0][0]; int ry = now[0][1];
        int bx = now[1][0]; int by = now[1][1];
        
        if(cost + 1 >= answer) return;
        
        for(int i = 0; i < 4; i++){
            int nrx = maze[rx][ry] == 3? rx: rx + dir[i][0];
            int nry = maze[rx][ry] == 3? ry: ry + dir[i][1];

            if(maze[rx][ry] != 3 && !check(maze, nrx, nry, 0)){
                continue;
            }
           
            for(int j = 0; j < 4; j++){
                int nbx = maze[bx][by] == 4? bx: bx + dir[j][0];
                int nby = maze[bx][by] == 4? by: by + dir[j][1];

                if(maze[bx][by] != 4 && !check(maze, nbx, nby, 1)){
                    continue;
                }
                
                if(nrx == nbx && nry == nby) continue;
                if((nrx == bx && nry == by) && (nbx == rx && nby == ry)) continue;
                if(maze[nrx][nry] == 3 && maze[nbx][nby] == 4){
                    answer = Math.min(answer, cost+1);
                    return;
                }
                
                visited[0][nrx][nry] = true;
                visited[1][nbx][nby] = true;
                
                dfs(new int[][]{{nrx, nry}, {nbx, nby}}, maze, cost+1);
                
                visited[0][nrx][nry] = false;
                visited[1][nbx][nby] = false;
            }
        }
    }
    static boolean check(int[][] maze, int x, int y, int idx){
        if(x < 0 || x >= height || y < 0 || y >= width || maze[x][y] == 5 || visited[idx][x][y]){
            return false;
        }
        return true;
    }
    
}
