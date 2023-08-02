import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b1744 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pqOverZero = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pqBelowZero = new PriorityQueue<>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//데이터를 그룹 4개로 분리
		int zero = 0;
		int one = 0;
		for(int i = 0; i < N; i ++) {
			int input = sc.nextInt();
			if (input > 1) {
				pqOverZero.add(input);
			}
			if (input < 0) {
				pqBelowZero.add(input);
			}
			if (input == 1) one++;
			if (input == 0) zero++;
		}
		
		int ans = 0;
		//양수 pq의 사이즈가 1이 될 때까지
		while (pqOverZero.size() > 1) {
			int first = pqOverZero.remove();
			int second = pqOverZero.remove();
			int sum = first * second;
			ans += sum;
		}
		if (!pqOverZero.isEmpty()) ans += pqOverZero.remove();
		
		//음수 pq의 사이즈가 1이 될 때까지
		while (pqBelowZero.size() > 1) {
			int first = pqBelowZero.remove();
			int second = pqBelowZero.remove();
			int sum = first * second;
			ans += sum;
		}
		
		if(!pqBelowZero.isEmpty() & zero == 0) {
			ans += pqBelowZero.remove();				
		}
		ans += one;	
		
		System.out.println(ans);
	}
}
