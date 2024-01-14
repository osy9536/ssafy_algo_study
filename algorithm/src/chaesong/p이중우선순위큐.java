import java.util.*;

//pq를 굳이 하나로 만들면
class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < operations.length; i++){
            String now = operations[i];
            if(now.charAt(0) == 'I'){
                pq.offer(Integer.valueOf(now.substring(2, now.length())));
            }else{
                if(!pq.isEmpty()){
                    if(now.charAt(2) == '1'){
                        PriorityQueue<Integer> temp = new PriorityQueue<>((o1, o2)->{
                            return o2-o1;
                        });
                        while(!pq.isEmpty()){
                            temp.offer(pq.poll());    
                        }
                        temp.poll();
                        while(!temp.isEmpty()){
                            pq.offer(temp.poll());
                        }
                    }else{
                        pq.poll();
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        if(pq.size() == 0){
            answer[0] = 0; answer[1] = 0;
        }else if(pq.size() == 1){
            answer[1] = 0; answer[0] = pq.poll();
        }else{
            answer[1] = pq.poll(); 
            PriorityQueue<Integer> temp = new PriorityQueue<>((o1, o2)->{
                return o2-o1;
            });
            while(!pq.isEmpty()){
                temp.offer(pq.poll());    
            }
            answer[0] = temp.poll();
        }
        return answer;
    }
}

//두개의 pq를 쓴다면
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2)->{
          return o2-o1;  
        });
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        for (String oper : operations) {
            if (oper.charAt(0) == 'I') {
                pqMax.add(Integer.parseInt(oper.substring(2)));
                pqMin.add(Integer.parseInt(oper.substring(2)));
            }

            else if (oper.charAt(0) == 'D') {
                if (!pqMax.isEmpty()) {
                    if (oper.charAt(2) == '1') {
                        int max = pqMax.peek();
                        pqMax.remove(max);
                        pqMin.remove(max);
                    } else {
                        int min = pqMin.peek();
                        pqMax.remove(min);
                        pqMin.remove(min);
                    }
                }
            }

        }
        if (!pqMax.isEmpty()) {
            answer[0] = pqMax.peek();
            answer[1] = pqMin.peek();
        }
        return answer;
    }
}
