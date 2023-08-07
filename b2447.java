import java.util.Scanner;

public class b2447 {
	static StringBuilder sb = new StringBuilder();
	static char A[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new char[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				A[i][j] = '*';
			}
		}
		star(0, 0, N, false);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(A[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	static void star(int x, int y, int n, boolean blank) {
		//공백칸일 경우
		if(blank) {
			for(int i = x; i < x + n; i++) {
				for(int j = y; j < y + n; j++) {
					A[i][j] = ' ';
				}
			}
			return;
		}
		//더이상 쪼갤 수 없는 블록일때
		if(n == 1) {
			return;
		}
		int size = n/3; int count = 0;
		for(int i = x; i < x + n; i += size) {
			for(int j = y; j < y + n; j += size) {
				count++;
				if(count == 5) {
					star(i, j, size, true);
				}else {
					star(i, j, size, false);
				}
			}
		}
	}
}
