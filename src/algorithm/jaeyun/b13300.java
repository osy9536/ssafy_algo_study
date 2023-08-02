package algorithm.jaeyun;

import java.util.Scanner;

public class b13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] male = new int[7];
        int[] female = new int[7];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 1) {
                male[b] += 1;
            }
            else {
                female[b] += 1;
            }
        }
        for (int i=1; i<7; i++) {
            sum += (male[i] + K - 1) / K;
            sum += (female[i] + K - 1) / K;
        }
        System.out.println(sum);
    }
}
