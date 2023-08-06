package ssafy_algo_study.src.minho;

import java.util.*;

public class b28279 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb= new StringBuilder();
        int n = sc.nextInt();
        for(int i=0 ; i< n ; i++){
            int input = sc.nextInt();
            if(input == 1 ){
                int a = sc.nextInt();
                dq.addFirst(a);
            }
            else if(input == 2){
                int a = sc.nextInt();
                dq.addLast(a);
            }
            else if(input == 3){
                if(dq.isEmpty()){
                    sb.append(-1+"\n");
                }else{
                    sb.append(dq.removeFirst()+"\n");
                }
            }
            else if(input == 4){
                if(dq.isEmpty()){
                    sb.append(-1+"\n");
                }else{
                    sb.append(dq.removeLast()+"\n");
                }
            }
            else if(input == 5){
                sb.append(dq.size()+"\n");
            }
            else if(input == 6){
                if(dq.isEmpty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            }
            else if(input == 7){
                if(!dq.isEmpty()) sb.append(dq.peekFirst()+"\n");
                else sb.append(-1+"\n");
            }
            else if(input == 8){
                if(!dq.isEmpty()) sb.append(dq.peekLast()+"\n");
                else sb.append(-1+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
