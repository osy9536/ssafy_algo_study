import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        int max_alp = 0, max_cop = 0;
        for(int i = 0; i < problems.length; i++){
            max_alp = Math.max(max_alp, problems[i][0]);
            max_cop = Math.max(max_cop, problems[i][1]);
        }
        
        if(max_alp <= alp && max_cop <= cop) return 0;
        
        if(max_alp <= alp){
            alp = max_alp;
        }
        
        if(max_cop <= cop){
            cop = max_cop;
        }
        
        int[][] dp = new int[max_alp+2][max_cop+2];
        
        for(int i = alp; i <= max_alp; i++){
            for(int j = cop; j <= max_cop; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= max_alp; i++){
            for(int j = cop; j <= max_cop; j++){
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int[] p: problems){
                    // 만약 풀 수 있는 문제라면
                    if(p[0] <= i && p[1] <= j){
                        if(max_alp < p[2]+i && max_cop < p[3]+j){
                            dp[max_alp][max_cop] = Math.min(dp[max_alp][max_cop], dp[i][j]+p[4]);
                        }else if(max_alp < p[2]+i){
                            dp[max_alp][j+p[3]] = Math.min(dp[max_alp][j+p[3]], dp[i][j]+p[4]);
                        }else if(max_cop < p[3]+j){
                            dp[i+p[2]][max_cop] = Math.min(dp[i+p[2]][max_cop], dp[i][j]+p[4]);
                        }else if(i+p[2] <= max_alp && j+p[3] <= max_cop){
                            dp[i+p[2]][j+p[3]] = Math.min(dp[i+p[2]][j+p[3]], dp[i][j]+p[4]);
                        }
                        
                    }
                }
            }
        }
        return dp[max_alp][max_cop];
    }
    
}
