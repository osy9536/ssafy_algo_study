import java.util.*;

class Solution {
    
    static int answer = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[8];
        dfs(dungeons, k, 0);
        return answer;
    }
    
    public void dfs(int[][] dungeons, int k, int depth){
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] || dungeons[i][0] > k){
                continue;
            }
            visited[i] = true;
            dfs(dungeons, k-dungeons[i][1], depth+1);
            visited[i] = false;
        }
        answer = Math.max(answer, depth);
    }
}
