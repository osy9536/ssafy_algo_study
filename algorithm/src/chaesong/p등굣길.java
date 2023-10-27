import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int dp[][] = new int[m][n];
        
        for(int i = 0; i < puddles.length; i++){
            dp[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }
        
        // 초깃값 설정
        for(int i = 0; i < m; i++){
            if(dp[i][0] == -1) {
                dp[i][0] = 0;
                int idx = i;
                while(idx < m){
                    if(dp[idx][0] == -1) dp[idx][0] = 0;
                    idx++;
                }
                break;
            }
            dp[i][0] = 1;
        }
        
        for(int j = 0; j < n; j++){
            if(dp[0][j] == -1) {
                dp[0][j] = 0;
                int idx = j;
                while(idx < n){
                    if(dp[0][idx] == -1) dp[0][idx] = 0;
                    idx++;
                }
                break;
            }
            dp[0][j] = 1;    
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;    
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}
