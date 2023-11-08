import java.util.*;

class Solution {
    static HashMap<String, Integer> hm;
    static String[] parent;
    static int[] money;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        parent = new String[enroll.length];
        money = new int[enroll.length];
        hm = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++){
            hm.put(enroll[i], i);
            if(referral[i].equals("-")){
                parent[i] = enroll[i];    
            }else{
                parent[i] = referral[i];   
            }
        }
        for(int i = 0; i < seller.length; i++){
            String now = seller[i];
            money[hm.get(now)] += amount[i] * 100;
            dfs(now, amount[i] * 100);
        }
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = money[i];
        }
        return answer;
    }
    static void dfs(String now, int res){
        if(parent[hm.get(now)].equals(now)){
            res /= 10;
            money[hm.get(now)] -= res;
            return;
        }
        res /= 10;
        if(res == 0) return;
        money[hm.get(now)] -= res;
        money[hm.get(parent[hm.get(now)])] += res;
        now = parent[hm.get(now)];
        dfs(now, res);
    }
}
