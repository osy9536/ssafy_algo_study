package algorithm.jaeyun;

import java.util.Scanner;

public class b09012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc=0; tc<T; tc++) {
            boolean isVPS = true;
            int cnt = 0;
            String str = sc.next();
            for (char c: str.toCharArray()) {
                if (c == '(') {
                    cnt++;
                }
                else if (c == ')') {
                    cnt--;
                }
                if (cnt < 0) {
                    isVPS = false;
                    break;
                }
            }
            if (cnt != 0) isVPS = false;
            if (isVPS) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
