package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        int ans  = 0;
        int calcul = 1;
        boolean isPrevClose = false;
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if(now == '(' || now == '[') {
                stack.push(now);
                isPrevClose = false;
                if(now == '('){
                    calcul *=2;
                } else {
                    calcul *=3;
                }
            } else if (now == ')') {
                if(stack.isEmpty() || stack.peek() == '['){
                    System.out.println(0);
                    return;
                }else {
                    if (isPrevClose){
                        stack.pop();
                        calcul /=2;
                    } else {
                        stack.pop();
                        ans += calcul;
                        calcul /=2;
                        isPrevClose = true;
                    }
                }
            } else if (now == ']') {
                if(stack.isEmpty() || stack.peek() == '('){
                    System.out.println(0);
                    return;
                }else {
                    if(isPrevClose){
                        stack.pop();
                        calcul /=3;
                    }else {
                        stack.pop();
                        ans +=calcul;
                        calcul /=3;
                        isPrevClose = true;
                    }
                }
            }
        }

        if(!stack.isEmpty()){
            System.out.println(0);
            return;
        }

        System.out.println(ans);

    }
}
