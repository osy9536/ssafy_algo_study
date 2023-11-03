import java.util.*;

class Solution {
    static int answer;
    static boolean visited[];
    public int solution(String begin, String target, String[] words) {
        boolean flag = false;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                flag = true;
                break;
            }
        }
        if(!flag) return 0;
        
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        dfs(0, begin, target, words);
        
        return answer;
    }
    static void dfs(int depth, String now, String target, String[] words){
        
        if(now.equals(target)){
            answer = Math.min(answer, depth);
            return;
        }
        
        if(depth > answer) return;
        
        
        for(int i = 0; i < words.length; i++){
            if(!visited[i]){
                int cnt = 0;
                for(int j = 0; j < words[i].length(); j++){
                    if(words[i].charAt(j) != now.charAt(j)){
                        cnt++;
                    }
                }
                if(cnt == 1){
                    visited[i] = true;
                    dfs(depth+1, words[i], target, words);
                    visited[i] = false;
                }
            }
        }
 
    }
}
