import java.util.Scanner;
import java.util.Stack;

public class b9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <= T; t++) {
			Stack<String> my = new Stack<>();
			String S = sc.nextLine();
			for(int i = 0; i < S.length(); i++) {
				String A = S.substring(i, i+1);
				if(my.isEmpty()) my.add(A);
				else {
					if(my.peek().equals("(")) {
						if(A.equals(")")) {
							my.pop();
						}
						else my.add(A);
					}else {
						my.add(A);
					}
				}
			}
			if(my.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
