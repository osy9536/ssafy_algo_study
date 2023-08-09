import java.util.Scanner;
import java.util.Stack;

public class swea_회문 {
	static String A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 받기
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			// 입력값 받기
			A = sc.nextLine();
			boolean check = isPaline(0, A.length()-1);
			// 회문
			if (check)
				System.out.println(0);
			else {
				boolean reCheck = isYusa(0, A.length()-1);
				if (reCheck)
					System.out.println(1);
				else
					System.out.println(2);
			}
		}
	}

	// 회문검사
	static boolean isPaline(int left, int right) {
		while(left <= right) {
			if(A.charAt(left) != A.charAt(right)) {
				return false;
			}
			left++; right--;
		}
		return true;
	}

	// 유사회문검사
	static boolean isYusa(int left, int right) {
		while(left <= right) {
			if(A.charAt(left) != A.charAt(right)) {
				boolean a = isPaline(left+1, right);
				boolean b = isPaline(left, right-1);
				//둘다 회문이 아니면
				if(!a && !b) return false;
				//둘 중 하나라도 회문이라면
				else return true;
			}
			left++; right--;
		}
		return true;
	}
}
