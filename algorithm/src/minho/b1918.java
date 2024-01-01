package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1918 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str =br.readLine();

        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < str.length(); i++){
            char now = str.charAt(i);

            switch (now){
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                     while(!st.isEmpty() && priority(st.peek()) >= priority(now)){
                         sb.append(st.pop());
                     }
                     st.add(now);
                     break;
                case '(':
                    st.add(now);
                    break;
                case ')':
                    while(!st.isEmpty() && st.peek() != '('){
                        sb.append(st.pop());
                    }
                    st.pop();
                    break;
                default:
                    sb.append(now);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        System.out.println(sb.toString());
    }
    public static int priority(char operator){

        if(operator=='(' || operator==')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

}
