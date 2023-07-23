package algorithm.src.minho;

import java.io.*;
import java.util.*;

public class b10773 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int sum=0;
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(br.readLine());
			if(num==0) {
				sum-=stack.peek();
				stack.pop();
			}else {
				stack.push(num);
				sum+=num;
			}
		}
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
	}
}
