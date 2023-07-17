package algorithm.src.chaesong;
import java.util.*;

public class b1546 {
    public static void main(String[] args){
           //입력값
           Scanner sc = new Scanner(System.in);
           int test_case = sc.nextInt();
           int scores[] = new int[test_case];
           for(int i =0; i < test_case; i++){
               scores[i] = sc.nextInt();
           }
           //max, sum구하기
           long max = 0;
           long sum = 0;
           for(int i = 0; i < test_case; i++){
               if(scores[i] > max){
                   max = scores[i];
               }
               sum += scores[i];
           }
           System.out.println((sum * 100.0 / max) / test_case);
       }
}
