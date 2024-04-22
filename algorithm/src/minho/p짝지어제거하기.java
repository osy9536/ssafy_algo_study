import java.util.*;
class p짝지어제거하기
{
    public int solution(String s)
    {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = arr[i];
            if(st.isEmpty()) st.push(c);
            else{
                if(st.peek()==c) st.pop();
                else st.push(c);
            }
        }
        return st.isEmpty()?1:0;
    }
}