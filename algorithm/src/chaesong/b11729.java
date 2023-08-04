import java.util.Scanner;

public class b11729 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sb.append((int)Math.pow(2, N) - 1).append('\n');
		hanoi(1, 2, 3, N);
		System.out.println(sb);
	}
	static void hanoi(int start, int m, int end, int num) {
		//종료조건
		if(num == 0) return;
		//로직
		hanoi(start, end, m, num-1);
		sb.append(start + " " + end + "\n"); 
		//실제 움직이는건 마지막 원판밖에 없음
		hanoi(m, start, end, num-1);
	}
}
