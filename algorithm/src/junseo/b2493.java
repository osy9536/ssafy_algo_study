package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int [] arr  = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Stack<List<Integer>> stack = new Stack<>();
		sb.append(0).append(" ");
		for (int i = 0; i < N; i++) {
			int target = arr[i];
			while(!stack.isEmpty()) {
				if(stack.peek().get(1)<target) {
					stack.pop();
				}
				else {
					sb.append(stack.peek().get(0)+1).append(" ");
					break;
				}
				if(stack.isEmpty()) sb.append(0).append(" ");
			}
			stack.push(Arrays.asList(i,target));
		}
		System.out.println(sb);
	}
}

