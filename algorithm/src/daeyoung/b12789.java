package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 12789
 * 도키도키 간식드리미
 * 실버3
 * https://www.acmicpc.net/problem/12789
 */
public class b12789 {
	
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int n = Integer.parseInt(st.nextToken());
		 st = new StringTokenizer(br.readLine());
		 Queue<Integer> q = new LinkedList<>();
		 
		 for(int i = 0; i < n; i++)
			 q.add(Integer.parseInt(st.nextToken()));
		 
		 Stack<Integer> s = new Stack<>();
		 int cur = 1;
		 while(!q.isEmpty()) {
			 
			 if(cur != q.peek()) {
				 if(!s.isEmpty() && cur == s.peek()) {
					 s.pop();
					 cur++;
				 } else
					 s.add(q.poll());
			 }else {
				 q.poll();
				 cur++;
			 }
				
		 }
		 
		 String answer = "Nice";
		 while(!s.isEmpty()) {
			 if(cur == s.peek()) {
				 s.pop();
				 cur++;
			 } else {
				 answer = "Sad";
				 break;
			 }
		 }
		 
		 System.out.println(answer);
		 
	}

}
