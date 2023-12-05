import java.util.*;

class Solution {
    static int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static String[] term = {"d", "l", "r", "u"};
    static int width, height;
    static String ans;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        width = n;
        height = m;
        ans = "z";
        int diff = Math.abs((x-1) - (r-1)) + Math.abs((y-1) - (c-1));
        if((diff%2 == 0 && k%2 == 0) || (diff%2 == 1 && k%2 == 1)){
            dfs(k, x-1, y-1, r-1, c-1, "", diff);
        } 
        
        if(ans.equals("z")){
            return "impossible";
        }else{
            return ans;
        }
    }
    public static boolean dfs(int k, int x, int y, int r, int c, String res, int diff){
        if(k == 0 && diff == 0){
            ans = res;    
            return true;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(check(nx, ny) && (k >= diff)){
                if(dfs(k-1, nx, ny, r, c, res+term[i], Math.abs(nx-r)+Math.abs(ny-c))){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean check(int x, int y){
        return 0 <= x && x < width && 0 <= y && y < height;
    }
}
