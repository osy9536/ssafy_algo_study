package algorithm.chaesong;

import java.util.Scanner;
import java.util.Stack;

public class b1874 {
	public static void main(String[] args) {
		//�Է°� �ޱ�
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		} 
		
		//���� ��� �ÿ� �����������
		Stack<Integer> stack = new Stack<>();
		//+, -�� ǥ���ϱ� ���� bf
		StringBuffer bf = new StringBuffer();
		//result�� true�϶��� ���
		boolean result = true;
		
		//cnt�� ���� ���ÿ� ���� �� 
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (cnt <= A[i]) {
				//���� ������ ������ ���ÿ� push
				while(cnt <= A[i]) {
					stack.push(cnt);
					bf.append("+\n");
					cnt++;
				}
				//�������� pop
				if(A[i] == cnt-1) {
					stack.pop();
					bf.append("-\n");
				}				
			}
			//���ÿ� �� ���ڰ� ������ ������ ũ�ٸ�
			//�ϴ� ��
			else {
				if (A[i] < stack.peek()) {
					result = false;
					System.out.println("NO");
					break;
				}
				else {
					stack.pop();
					bf.append("-\n");
				}
			}
		}
		if(result) System.out.println(bf.toString());
	}
}
