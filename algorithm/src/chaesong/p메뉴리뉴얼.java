import java.util.*;

class Solution{
    static HashMap<String, Integer> hm;
    static int m;
    public String[] solution(String[] orders, int[] course){
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        //course = [2, 3, 4]
        for(int i = 0; i < course.length; i++){
            hm = new HashMap<>();
            m = 0;
            //orders = ["ABCFG", "AC", "CDE", "ACDE", ...]
            for(int j = 0; j < orders.length; j++){
                comb("", course[i], 0, orders[j]);        
            }
            for(String s: hm.keySet()){
                if(hm.get(s) == m && m > 1){
                    pq.offer(s);
                }
            }
        }
        String ans[] = new String[pq.size()];
        int k = 0;
        while(!pq.isEmpty()){
            ans[k++] = pq.poll();
        }
        return ans;
    }
    
    static void comb(String str, int targetNum, int idx, String word){
        if(str.length() == targetNum){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temp = new String(c);
            hm.put(temp, hm.getOrDefault(temp, 0)+1);
            m = Math.max(m, hm.get(temp));
            return;
        }
        for(int i = idx; i < word.length(); i++){
            char now =  word.charAt(i);
            comb(str+now, targetNum, i+1, word);
        }
    }
}
