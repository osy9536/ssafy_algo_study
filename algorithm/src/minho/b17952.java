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

class Work{ //일객체
	int score; //점수
	int time; //시간
	public Work(int score, int time) { //생성자
		super();// 생성자
		this.score = score; //점수설정
		this.time = time; //시간설정
	}
}
public class b17952 {
	static Stack<Work> s = new Stack<>(); //문제 구조상 stack 구현필요
	static int totalScore=0; //출력값 , 정답
	
	public static void check() { // 확인하는함수
		if(s.peek().time == 0) { // 스택맨위에 일이 시간이 0이면
			totalScore += s.peek().score; // 점수 얻고
			s.pop(); //stack에서 제거
		}
	}
	public static void work() { //일하는함수
		s.peek().time-=1; //시간1감소
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferedreader
		int T = Integer.parseInt(br.readLine()); // 시간입력
		
		for(int i = 0 ; i < T; i++) { //일시작 T만큼
			StringTokenizer st = new StringTokenizer(br.readLine()); //처음입력값
			int n = Integer.parseInt(st.nextToken()); //정수변환
			
			if(n==0) { //0이면 일이 안들어온것
				if(s.isEmpty()) { //스택 비어있으면
					continue; // 일할게없다.
				}
				else { //일할게 있으면
					work(); //일하고
					check(); //일얼마나 남았나 검사
				}
			}
			else { //1이면 일이 들어온것
				s.add(new Work(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))); //객체 Work stack 저장
				work(); //일하고
				check(); //일얼마나 남았나 검사
			}
		}
		System.out.println(totalScore); //토탈점수 출력
	}
}