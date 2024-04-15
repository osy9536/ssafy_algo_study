package algorithm.src.daeyoung;

/**
 * 프로그래머스 - 스킬트리
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/49993
 */
public class p49993 {

    public static void main(String[] args) {
        int answer = 0;
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
      
        for(String s : skill_trees) {
            StringBuilder num = new StringBuilder();
            
            for(char c : s.toCharArray()) {
                for(int i = 0; i < skill.length(); i++) {
                    if(c == skill.charAt(i)) {
                        num.append(i);
                        break;
                    }
                }
            }
            
            if(num.length() != 0) {
                boolean isAdd = true;
                for(int i = 0; i < num.length(); i++) {
                    if(num.charAt(i) - '0' != i ) {
                        isAdd = false;
                        break;
                    }
                }
                
                if(isAdd)
                    answer++;
            } else
                answer++;
            
        }
        
        System.out.println(answer);    
    }
}
