import java.util.*;

class Solution {
    static class Node{
        int start;
        int time;
        int end;
        public Node(int start, int time){
            this.start = start;
            this.time = time;
            this.end = start+time;
        }
    }
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a, b) -> {
            return a[0] - b[0];
        });
        
        Queue<Node> waitQueue = new LinkedList<>();
        for(int i = 0; i < jobs.length; i++){
            waitQueue.offer(new Node(jobs[i][0], jobs[i][1]));
        }
        
        
        // 들어간 다음부터는 적게 걸린 순서대로 정렬 SJF
        PriorityQueue<Node> taskQueue = new PriorityQueue<>((a, b)->{
            return a.time - b.time;
        });
        
        int current = 0;   // 수행되고 난 직후의 시간
        int total = 0; // 전체 수행시간
        
        // 작업이 전부 수행될 때까지 반복
        while((!waitQueue.isEmpty()) || (!taskQueue.isEmpty())){
            // 작업을 해줄 내용이 있다면 작업 진행
            if(!taskQueue.isEmpty()){
                Node temp = taskQueue.poll();
                total += current-temp.start + temp.time;
                current += temp.time;
            }
            
            // 작업을 waitQ -> TaskQ 로 이동
            while(!waitQueue.isEmpty() && waitQueue.peek().start <= current){
                taskQueue.offer(waitQueue.poll());
            }
            
            // 위에 이동을 진행하였는데도 불구하고, TaskQ 비어있는데, waitQ 가 차있는 경우! current 시간을 변경...!
            if(taskQueue.isEmpty() && !waitQueue.isEmpty()){
                current = waitQueue.peek().start;
            }
        }
        return total / jobs.length;
    }
}
