import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class b24511 { 

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		boolean flag[] = new boolean[n];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(st.nextToken()) == 0) {
				flag[i] = true;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int num=Integer.parseInt(st.nextToken());
			if (flag[i])
				stack.add(num);
		}

		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}

		int m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			int num=Integer.parseInt(st.nextToken());
			queue.add(num);
			bw.write(queue.poll() + " ");

		}
		bw.flush();
	}
}