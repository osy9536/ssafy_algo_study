package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int n;
	static StringBuilder sb = new StringBuilder();
	public static void make(int cnt,int prime) {
		if(cnt==0) {if(checkit(prime)) sb.append(prime+"\n"); return ;}
		for(int i=1;i<10;i++) {
			if(checkit(prime*10+i)) make(cnt-1,prime*10+i);
		}
	}
	public static boolean checkit(int num) {
		if(num<2) return false;
		for(int i = 2 ; i <= Math.sqrt(num) ; i ++) {
			if(num%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		make(n,0);
		System.out.println(sb);
	}
}
/*
신기한 소수
자릿수 입력
자릿수에 따른 소수찾아 배열넣기
배열에 넣은후

*/