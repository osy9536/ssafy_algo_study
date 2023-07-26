import java.util.Scanner;
import java.util.Stack;

public class b1874 {
	public static void main(String[] args) {
		//입력값 받기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		} 
		
		//스택 사용 시에 선언해줘야함
		Stack<Integer> stack = new Stack<>();
		//+, -를 표시하기 위한 bf
		StringBuffer bf = new StringBuffer();
		//result가 true일때만 출력
		boolean result = true;
		
		//cnt는 아직 스택에 들어가기 전 
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (cnt <= A[i]) {
				//값이 같아질 때까지 스택에 push
				while(cnt <= A[i]) {
					stack.push(cnt);
					bf.append("+\n");
					cnt++;
				}
				//같아지면 pop
				if(A[i] == cnt-1) {
					stack.pop();
					bf.append("-\n");
				}				
			}
			//스택에 들어갈 숫자가 수열의 값보다 크다면
			//일단 빼
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
