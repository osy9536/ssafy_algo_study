package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class b9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        for(int i=0;i<a;i++) {
            String s = br.readLine();
            System.out.println(f(s)); //리턴값 출력
        }
    }
    public static String f(String str) {
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            if(c=='(') {
                stack.push(c);
            }else if(c==')') {
                if(stack.empty())
                    return "NO";
                else {
                    stack.pop();
                }
            }
        }
        if(stack.empty())
            return "YES";
        else
            return "NO";
    }
}
