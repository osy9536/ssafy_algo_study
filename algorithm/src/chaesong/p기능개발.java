import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 마무리될 때까지 걸리는 시간
        int days[] = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            double temp = (100-progresses[i]) % speeds[i];
            if(temp == 0.0){
                days[i] = (int)(100-progresses[i]) / speeds[i]; 
            }else{
                days[i] = (int)(100-progresses[i]) / speeds[i] + 1;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < days.length; i++){
            int temp = 0;
            if(!q.isEmpty()){
                if(days[i] <= q.peek()){
                    q.add(days[i]);
                }else{
                    while(!q.isEmpty()){
                        q.poll();
                        temp++;
                    }
                    ans.add(temp);
                    q.add(days[i]);
                }
            }
            else q.add(days[i]);
        }
        int temp = 0;
        while(!q.isEmpty()){
            q.poll();
            temp++;
        }
        ans.add(temp);
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
