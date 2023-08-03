import java.util.Scanner;

public class b1747 {
	public static void main(String[] ars) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = N;
		while(true) {
			if (is_prime(ans) & falen(ans)) {
				System.out.println(ans);
				break;
			}
			ans++;
		}
		
	}
	static boolean is_prime (int x) {
		if(x <= 1)
			return false;
		if(x == 2)
			return true;
		for(int i = 2; i*i <= x; i ++) {
			if(x % i == 0)
				return false;
		}
		return true;
	}
	static boolean falen (int x) {
		String origin = String.valueOf(x);
		StringBuffer sb = new StringBuffer();
		sb.append(origin);
		String reverse = sb.reverse().toString();
		if (reverse.equals(origin)) {
			return true;			
		}
		else return false;
	}
}
