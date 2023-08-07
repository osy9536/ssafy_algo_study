package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class b12789 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue <Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		int next = 1;
		Stack <Integer> stack = new Stack<>();
		while(!queue.isEmpty()) {
			int a = queue.peek();
			if (a == next) {
				queue.poll();
				next++;
			} else {
				if (!stack.isEmpty() && stack.peek() == next) {
					next++;
					stack.pop();
				} else {
					queue.poll();
					stack.push(a);
				}
			}
		}
		
		int size = stack.size();
		boolean flag = true;
		for(int i = 0;i<size;i++) {
			if(stack.peek() != next) {
				flag = false;
				break;
			}
			else {
				stack.pop();
				next++;
			}
		}
		if(flag) System.out.println("Nice");
		else 	 System.out.println("Sad");
	}

}
