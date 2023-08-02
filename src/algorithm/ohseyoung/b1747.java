package algorithm.ohseyoung;

import java.util.Scanner;
// 실버 1
// 소수&팰린드롬
public class b1747 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] a = new int[10000001];
		for (int i = 2; i < a.length; i++) {
			a[i] = i;
		}
		for (int i = 2; i < Math.sqrt(a.length); i++) {
			if (a[i] == 0)
				continue;
			for (int j = i + i; j < a.length; j += i) {
				a[j] = 0;
			}
		}

		for (int i = n; i < a.length; i++) {
			if (a[i] == 0)
				continue;
			if (isPal(a[i])) {
				System.out.println(a[i]);
				break;
			}
		}
	}
	
	static boolean isPal(int num) {
        int originalNum = num;
        int reverseNum = 0;
        while (num > 0) {
            int digit = num % 10;
            reverseNum = reverseNum * 10 + digit;
            num /= 10;
        }
        return originalNum == reverseNum;
    }
}
