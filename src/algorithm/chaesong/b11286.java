package algorithm.chaesong;

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
			//���� ��
			if(first_abs == second_abs) {
				//���� ���� �켱������ ��
				return a > b? 1 : -1;
			}
			//a>b�� b�� �켱����, a<b�� a�� �켱����
			else {
				return first_abs - second_abs;
			}
		});
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			//�Է��� 0�� ����
			if(input == 0) {
				//����ִٸ� 0 ���
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				//������� �ʴٸ� ó�� �� ����
				else {
					System.out.println(pq.poll());
				}
			}
			//�Է°����� �ٸ� ���ڰ� ���� ����
			else {
				pq.add(input);
			}		
		}
	}
}
