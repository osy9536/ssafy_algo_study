package ssafy_algo_study.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//12789번 도키도키 간식드리미
public class b12789{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new ArrayDeque<>();
		Stack<Integer> st = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i =0 ;i<n;i++) {
			int a = Integer.parseInt(str.nextToken());
			q.offer(a);
		}
	
		int num=1;
		boolean answer = true;
		while(!q.isEmpty()) {
			if(!q.isEmpty() && q.peek()==num)
			{
				q.poll();
				num++;
			}
			else if (!st.isEmpty() && st.peek()== num )
			{	st.pop();
				num++;
			}
			else {
				st.add(q.poll());
			}
		}
		while(!st.isEmpty()) {
			if(st.peek()==num){	
				st.pop();
				num++;
			}
			else {
				System.out.println("Sad");
				return;
			}
		}
		System.out.println("Nice");
	}
}












