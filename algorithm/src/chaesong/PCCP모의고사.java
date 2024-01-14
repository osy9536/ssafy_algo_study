import java.util.*;
import java.io.*;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        char[] c = input_string.toCharArray();
        HashSet<Character> hs = new HashSet<>();
        ArrayList<Character> arr = new ArrayList<>();
        for(int i = 0; i < c.length-1; i++){
            if(c[i] != c[i+1]){
                if(!hs.contains(c[i])){
                    hs.add(c[i]);    
                }else{
                    if(!arr.contains(c[i])) arr.add(c[i]);
                }
            }
        }
        if(hs.contains(c[c.length-1]) && !arr.contains(c[c.length-1])) arr.add(c[c.length-1]);
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.size(); i++){
            sb.append(arr.get(i));
        }
        answer = sb.toString();
        if(answer.length() == 0) answer = "N";
        return answer;
    }
}
