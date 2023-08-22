package algorithm.src.minho;
import java.io.IOException;
import java.util.Scanner;

public class b10162 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in); //scanner
		int T = sc.nextInt(); //T 시간
		int a=0,b=0,c=0; // 출력값
		if((T/300)>0) { //300보다 큰값인가?
			a=T/300;//T를 나눈값
			T%=300;//나머지값 저장
		}
		if((T/60)>0) { //60보다 큰값인가?
			b=T/60;//T를 나눈값
			T%=60;//나머지값 저장
		}
		if((T/10)>0) { // 10보다 큰값인가?
			c=T/10;			//T를 나눈값
			T%=10;//나머지값 저장
		}
		if(T==0) { //T가 나누어 떨어지면 
			System.out.print(a+" "+b+" "+c); //출력
		}else { //T가 나누어 떨어지지 않으면
			System.out.println(-1); //출력
		}
		sc.close(); //scanner닫기
	}
}
