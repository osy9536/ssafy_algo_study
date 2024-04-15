package algorithm.src.ohseyoung;
import java.util.*;

// 전화번호 목록
// lv 2
class s42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<phone_book.length; i++){
            map.putIfAbsent(phone_book[i],i);
        }
        
        for(String s : phone_book){
            for(int i = 0; i<s.length(); i++){
                if(map.containsKey(s.substring(0,i))){
                    answer = false;
                }
            }
        }
        return answer;
    }
}
