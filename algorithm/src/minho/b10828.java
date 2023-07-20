package algorithm.src.minho;

import java.io.*;
import java.util.*;

public class b10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); //입력 받고
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(st.nextToken()); //숫자입력 말이안됨 
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("top")) { //맨처음
				if(stack.size()>0)
					System.out.println(stack.peek());
				else
					System.out.println(-1);
			}
			else if(s.equals("empty")) { //비었는가?
			
				if(stack.empty())
					System.out.println(1);
				else if(!stack.empty())
					System.out.println(0);
			}
			else if(s.equals("pop")) { //뽑기
			
				if(stack.size()>0)
					System.out.println(stack.pop());
				else
					System.out.println(-1);
			}
			else if(s.equals("size")) { //사이즈
				System.out.println(stack.size());
			}
			else if(s.equals("push")) { //입력
			
				int number =Integer.parseInt(st.nextToken());
				stack.push(number);
			}	
			
		}
	}
}
