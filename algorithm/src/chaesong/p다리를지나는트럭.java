import java.util.*;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> going = new LinkedList<>();
        int now = 0;
        
        for(int i = 0; i < truck_weights.length; i++){
            int truck = truck_weights[i];
            while(true){
                if(going.isEmpty()){
                    going.add(truck);
                    now += truck;
                    answer++;
                    break;
                }
                //이미 꽉 찼다면-> 앞에 있는 트럭 빼기
                else if(going.size() == bridge_length){
                    int temp = going.poll();
                    now -= temp;
                }else{
                    //가능한 무게라면
                    if(now + truck_weights[i] <= weight){
                        going.add(truck);
                        now += truck;
                        answer++;
                        break;
                    }
                    //못 올림-> 올릴 수 있을 때까지 0 밀어넣기
                    else{
                        going.add(0);
                        answer++;
                    }    
                }   
            }
            
        }
        
        
        return answer+bridge_length;
    }
}
