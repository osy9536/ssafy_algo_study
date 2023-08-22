package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Work{ //�ϰ�ü
	int score; //����
	int time; //�ð�
	public Work(int score, int time) { //������
		super();// ������
		this.score = score; //��������
		this.time = time; //�ð�����
	}
}
public class b17952 {
	static Stack<Work> s = new Stack<>(); //���� ������ stack �����ʿ�
	static int totalScore=0; //��°� , ����
	
	public static void check() { // Ȯ���ϴ��Լ�
		if(s.peek().time == 0) { // ���ø����� ���� �ð��� 0�̸�
			totalScore += s.peek().score; // ���� ���
			s.pop(); //stack���� ����
		}
	}
	public static void work() { //���ϴ��Լ�
		s.peek().time-=1; //�ð�1����
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferedreader
		int T = Integer.parseInt(br.readLine()); // �ð��Է�
		
		for(int i = 0 ; i < T; i++) { //�Ͻ��� T��ŭ
			StringTokenizer st = new StringTokenizer(br.readLine()); //ó���Է°�
			int n = Integer.parseInt(st.nextToken()); //������ȯ
			
			if(n==0) { //0�̸� ���� �ȵ��°�
				if(s.isEmpty()) { //���� ���������
					continue; // ���ҰԾ���.
				}
				else { //���Ұ� ������
					work(); //���ϰ�
					check(); //�Ͼ󸶳� ���ҳ� �˻�
				}
			}
			else { //1�̸� ���� ���°�
				s.add(new Work(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))); //��ü Work stack ����
				work(); //���ϰ�
				check(); //�Ͼ󸶳� ���ҳ� �˻�
			}
		}
		System.out.println(totalScore); //��Ż���� ���
	}
}