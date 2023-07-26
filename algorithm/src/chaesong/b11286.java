import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int first_abs = Math.abs(a);
			int second_abs = Math.abs(b);
			//같을 땐
			if(first_abs == second_abs) {
				//작은 수에 우선순위를 둠
				return a > b? 1 : -1;
			}
			//a>b면 b에 우선순위, a<b면 a에 우선순위
			else {
				return first_abs - second_abs;
			}
		});
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			//입력이 0일 때는
			if(input == 0) {
				//비어있다면 0 출력
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				//비어있지 않다면 처음 꺼 제거
				else {
					System.out.println(pq.poll());
				}
			}
			//입력값으로 다른 숫자가 들어올 때는
			else {
				pq.add(input);
			}		
		}
	}
}
