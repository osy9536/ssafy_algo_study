package ssafy_algo_study.src.minho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class b2493 {
	public static class info {
		public int num;
		public int height;
		public info(int num, int height) {
			super();
			this.num = num;
			this.height = height;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<info> stack = new Stack<info>();
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(true) {
				if(stack.isEmpty()) {
					stack.add(new info(i,num));
					answer.append(0);
					break;
				}
				else {
					if(stack.peek().height > num){
						answer.append(stack.peek().num+1);
						stack.add(new info(i,num));
						break;
					}
					else {
						stack.pop();	
					}
				}
			}
			if(i!=n-1) answer.append(" ");
		}
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}
}











