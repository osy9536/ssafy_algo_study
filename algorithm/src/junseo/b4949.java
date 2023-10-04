package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) break;
			ArrayDeque<Character> stack = new ArrayDeque<>();
			for (int i = 0; i < str.length(); i++) {
				char a = str.charAt(i);
				if(a == '.') {
					if(stack.isEmpty()) sb.append("yes").append("\n");
					else sb.append("no").append("\n");
					break;
				}
				else if(a == '(' || a == '[') {
					stack.push(a);
				}
				else if(a == ')') {
					if(stack.isEmpty() || stack.peek() != '(') { 
						sb.append("no").append("\n");
						break;
					}
					else {
						stack.pop();
					}
				}
				else if(a == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						sb.append("no").append("\n");
						break;
					}
					else {
						stack.pop();
					}
				}
			}
		}
		System.out.println(sb);
	}
}


