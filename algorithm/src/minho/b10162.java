package algorithm.src.minho;
import java.io.IOException;
import java.util.Scanner;

public class b10162 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in); //scanner
		int T = sc.nextInt(); //T �ð�
		int a=0,b=0,c=0; // ��°�
		if((T/300)>0) { //300���� ū���ΰ�?
			a=T/300;//T�� ������
			T%=300;//�������� ����
		}
		if((T/60)>0) { //60���� ū���ΰ�?
			b=T/60;//T�� ������
			T%=60;//�������� ����
		}
		if((T/10)>0) { // 10���� ū���ΰ�?
			c=T/10;			//T�� ������
			T%=10;//�������� ����
		}
		if(T==0) { //T�� ������ �������� 
			System.out.print(a+" "+b+" "+c); //���
		}else { //T�� ������ �������� ������
			System.out.println(-1); //���
		}
		sc.close(); //scanner�ݱ�
	}
}
