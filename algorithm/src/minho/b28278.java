package ssafy_algo_study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class b28278{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i = 0 ; i < n ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int input=Integer.parseInt(st.nextToken());
			if(input==1) { 
				int next = Integer.parseInt(st.nextToken());
				stack.add(next);
				continue;
			}
			else if(input==2) {
				if(stack.isEmpty()) bw.write("-1\n");
				else bw.write(String.valueOf(stack.pop())+"\n");
				continue;
			}
			else if(input==3) {
				bw.write(String.valueOf(stack.size())+"\n");
				continue;
			}
			else if(input==4) {
				if(stack.isEmpty())	bw.write("1\n");
				else bw.write("0\n");
				continue;
			}
			else if(input==5) {
				if(stack.isEmpty()) bw.write("-1\n");
				else bw.write(String.valueOf(stack.peek())+"\n");
				continue;
			}
		}
		bw.flush();
		bw.close();
	}
}

